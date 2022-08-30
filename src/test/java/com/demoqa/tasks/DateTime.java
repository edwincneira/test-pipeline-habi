package com.demoqa.tasks;

import com.demoqa.interactions.NavigateDatePicker;
import com.demoqa.interactions.DateAndTime;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class DateTime implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                NavigateDatePicker.nav(),
                DateAndTime.in()
                //Ensure.that(SeeAttribute.on(LABEL_DATE_AND_TIME_TEXT, String.valueOf(year))).isTrue()

                //Sin validacion ya que estoy ingresando la fecha de manera erronea
        );
    }

    public static DateTime searchDateAndTime(){
        return Tasks.instrumented(DateTime.class);
    }
}
