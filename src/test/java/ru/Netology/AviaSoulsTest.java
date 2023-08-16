package ru.Netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void ticketSearch() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Шер", "Тол", 1000, 10, 14);
        Ticket ticket2 = new Ticket("Пул", "Внук", 2000, 12, 14);
        Ticket ticket3 = new Ticket("Шер", "Тол", 2000, 14, 16);
        Ticket ticket4 = new Ticket("Пул", "Внук", 4000, 10, 12);
        Ticket ticket5 = new Ticket("Шер", "Тол", 7000, 10, 12);
        Ticket ticket6 = new Ticket("Шер", "Тол", 4000, 10, 12);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

        Ticket[] actual = manager.search("Шер", "Тол");
        Ticket[] expected = {ticket1, ticket3, ticket6, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void negativeSearch() {
        AviaSouls manager = new AviaSouls();

        Ticket tick1 = new Ticket("Шер", "Тол", 1000, 10, 14);
        Ticket tick2 = new Ticket("Пул", "Внук", 2000, 12, 14);
        Ticket tick3 = new Ticket("Шер", "Тол", 2000, 14, 16);
        Ticket tick4 = new Ticket("Пул", "Внук", 4000, 10, 12);
        Ticket tick5 = new Ticket("Шер", "Тол", 5000, 10, 12);
        Ticket tick6 = new Ticket("Шер", "Тол", 4000, 10, 12);
        manager.add(tick1);
        manager.add(tick2);
        manager.add(tick3);
        manager.add(tick4);
        manager.add(tick5);
        manager.add(tick6);

        Ticket[] actual = manager.search("Нов", "Ростов");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void boundarySearch() {
        AviaSouls manager = new AviaSouls();

        Ticket tick1 = new Ticket("Шер", "Тол", 1000, 10, 14);
        Ticket tick2 = new Ticket("Пул", "Внук", 2000, 12, 14);
        Ticket tick3 = new Ticket("Шер", "Тол", 2000, 14, 16);
        Ticket tick4 = new Ticket("Нов", "Ростов", 4000, 10, 12);
        Ticket tick5 = new Ticket("Шер", "Тол", 5000, 10, 12);
        Ticket tick6 = new Ticket("Шер", "Тол", 4000, 10, 12);
        manager.add(tick1);
        manager.add(tick2);
        manager.add(tick3);
        manager.add(tick4);
        manager.add(tick5);
        manager.add(tick6);

        Ticket[] actual = manager.search("Нов", "Ростов");
        Ticket[] expected = {tick4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket tick1 = new Ticket("Шер", "Тол", 1000, 10, 16);//6
        Ticket tick2 = new Ticket("Пул", "Внук", 2000, 12, 14);
        Ticket tick3 = new Ticket("Шер", "Тол", 2000, 14, 16);//2
        Ticket tick4 = new Ticket("Нов", "Ростов", 4000, 10, 12);
        Ticket tick5 = new Ticket("Шер", "Тол", 5000, 10, 18);//8
        Ticket tick6 = new Ticket("Шер", "Тол", 4000, 10, 20);//10
        manager.add(tick1);
        manager.add(tick2);
        manager.add(tick3);
        manager.add(tick4);
        manager.add(tick5);
        manager.add(tick6);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Шер", "Тол", comparator);
        Ticket[] expected = {tick3, tick1, tick5, tick6};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void negativSortWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket tick1 = new Ticket("Шер", "Тол", 1000, 10, 16);//6
        Ticket tick2 = new Ticket("Пул", "Внук", 2000, 12, 14);
        Ticket tick3 = new Ticket("Шер", "Тол", 2000, 14, 16);//2
        Ticket tick4 = new Ticket("Нов", "Ростов", 4000, 10, 12);
        Ticket tick5 = new Ticket("Шер", "Тол", 5000, 10, 18);//8
        Ticket tick6 = new Ticket("Шер", "Тол", 4000, 10, 20);//10
        manager.add(tick1);
        manager.add(tick2);
        manager.add(tick3);
        manager.add(tick4);
        manager.add(tick5);
        manager.add(tick6);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Влад", "Керч", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void boundarySortWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket tick1 = new Ticket("Шер", "Тол", 1000, 10, 16);//6
        Ticket tick2 = new Ticket("Пул", "Внук", 2000, 12, 14);
        Ticket tick3 = new Ticket("Шер", "Тол", 2000, 14, 16);//2
        Ticket tick4 = new Ticket("Нов", "Ростов", 4000, 10, 12);
        Ticket tick5 = new Ticket("Шер", "Тол", 5000, 10, 18);//8
        Ticket tick6 = new Ticket("Шер", "Тол", 4000, 10, 20);//10
        manager.add(tick1);
        manager.add(tick2);
        manager.add(tick3);
        manager.add(tick4);
        manager.add(tick5);
        manager.add(tick6);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("Нов", "Ростов", comparator);
        Ticket[] expected = {tick4};
        Assertions.assertArrayEquals(expected, actual);
    }
}
