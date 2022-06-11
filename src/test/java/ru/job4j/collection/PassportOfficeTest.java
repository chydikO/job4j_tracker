package ru.job4j.collection;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addDuplicatePassport() {
        Citizen citizen1 = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen2 = new Citizen("2f44a", "Ivan Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen1);
        Assert.assertFalse(office.add(citizen2));
    }

    @Test
    public void get() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get("2f44a"), is(citizen));
    }
}