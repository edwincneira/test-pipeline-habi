package com.demoqa.tasks;

import com.demoqa.interactions.NavigateTables;
import com.demoqa.questions.SeeText;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import com.demoqa.utils.IsPerson;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;

import static com.demoqa.user_interfaces.HomePage.BTN_ADD_REGISTER;
import static com.demoqa.user_interfaces.RegisterPage.getEmptyNameDeleted;
import static com.demoqa.utils.VariablesGlobals.rowItemIsPerson;
import static com.demoqa.user_interfaces.RegisterPage.getBasketForDeleteUser;
public class DeleteUser implements Task {

    private String name;
    private String lastName;
    private String email;
    private int age;
    private int salary;
    private String department;
    private String xpath = "//div[@class='rt-tbody']//child::div[%s]//div//child::*[%s]";
    private boolean isPerson = false;


    public DeleteUser(String name, String lastName, String email, int age, int salary, String department) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NavigateTables.nav()
        );

        isPerson = IsPerson.here(actor, name, lastName, email);

        if(isPerson){
            Target basket = getBasketForDeleteUser(String.valueOf(rowItemIsPerson));
            actor.attemptsTo(
                    Scroll.to(BTN_ADD_REGISTER),
                    Scroll.to(basket),
                    Click.on(basket)
            );
            actor.attemptsTo(
                    Ensure.that(SeeText.of(getEmptyNameDeleted(String.valueOf(rowItemIsPerson))).answeredBy(actor)).doesNotContain(name)
            );
        } else {
            Serenity.recordReportData().withTitle("Usuario no eliminado").andContents("EL usuario no existe en la pagina demoqa.com ");
        }

    }

    public static DeleteUser deleteUser(String name, String lastName, String email, int age, int salary, String department){
        return Tasks.instrumented(DeleteUser.class, name, lastName, email, age, salary, department);
    }

}
