package com.demoqa.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class SeeText implements Question<String> {
    private Target target;

    public SeeText(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).find(target).getText();
    }

    public static SeeText of(Target target) {
        return new SeeText(target);
    }
}
