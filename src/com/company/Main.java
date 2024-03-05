package com.company;

public class Main {

    public static void main(String[] args) {
	    // Паттерн (итерратор), позволяет сделать итерацию любой коллекции, которую мы сделаем
        // то есть пройтись по ней по шагам, даже если она состовная, большая и сложная
        ArreyContainer arreyContainer = new ArreyContainer();
        Iterator iterator = arreyContainer.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

// Указываем интерфейс и коллекцию
interface Iterator{
    boolean hasNext();
    Object next();
}

interface Container{
    Iterator getIterator();
}

class ArreyContainer implements Container{
    String[] arrey = {"Max", "Jhon", "Mike"};

    // вернёт класс в нутри которого есть итерация
    @Override
    public Iterator getIterator() {
        return new ArreyIterator();
    }

    class ArreyIterator implements Iterator{
        int index;

        // это не последний элемент?
        @Override
        public boolean hasNext() {
            return (index < arrey.length) ? true : false;
        }

        // шаг итерации
        @Override
        public Object next() {
            if (hasNext()){
                return arrey[index++];
            }
            return null;
        }
    }
}
