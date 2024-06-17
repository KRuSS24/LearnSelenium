package lesson_16.MyGenerator;

class NotThreadSafeIdGenerator {

    private static int id;

    public static int nextId() {
        return id++;
    }
}
