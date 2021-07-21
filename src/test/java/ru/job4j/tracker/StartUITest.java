package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.actions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class StartUITest {
    private final Output out = new StubOutput();

    @Test
    public void whenCreateAction() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }
    @Test
    public void whenReplaceAction() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        StringBuilder menuOut = new StringBuilder(
                "Menu." + System.lineSeparator() +
                        "0. Edit item" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator());
        UserAction[] actions = {
                new EditAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(new StubInput(
                        new String[]{
                                "0",
                                String.valueOf(item.getId()),
                                replacedName,
                                "1"
                        })
                , tracker, actions);
        String result = menuOut +
                "=== Edit item ====" + System.lineSeparator() +
                "Заявка изменена успешно." + System.lineSeparator() + menuOut;
        assertThat(out.toString(), is(result));
    }

    @Test
    public void whenDeleteAction() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("new item"));
        StringBuilder menuOut = new StringBuilder(
                "Menu." + System.lineSeparator() +
                        "0. Delete item" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator());
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(new StubInput(
                        new String[]{
                                "0",
                                String.valueOf(item.getId()),
                                "1"
                        })
                , tracker, actions);
        String result = menuOut +
                "=== Delete item ====" + System.lineSeparator() +
                "Заявка удалена успешно." + System.lineSeparator() + menuOut;
        assertThat(out.toString(), is(result));
    }

    @Test
    public void FindAllAction() {
        StringBuilder menuOut = new StringBuilder(
                        "Menu." + System.lineSeparator() +
                        "0. Add new Item" + System.lineSeparator() +
                        "1. Show all items" + System.lineSeparator() +
                        "2. Exit" + System.lineSeparator());
        Input in = new StubInput(
                new String[] {
                        "0", "Item name",
                        "1",
                        "2"
                }
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ShowAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        StringBuilder result = new StringBuilder(
                menuOut +
                "=== Create a new Item ====" + System.lineSeparator() +
                menuOut +
                "=== Show all items ====" + System.lineSeparator()
        );
        Item[] items = tracker.findAll();
        for (Item item: items) {
            result.append(item.toString());
        }
        result.append(System.lineSeparator()).append(menuOut);
        assertThat(out.toString(), is(result.toString()));
    }

    @Test
    public void whenFindByNameAction() {

    }

    @Test
    public void whenFindByIdAction() {

    }

    @Test
    public void whenExitAction() {
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }
}