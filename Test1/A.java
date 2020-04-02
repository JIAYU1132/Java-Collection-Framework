public class A<T> {
    T value;

    A(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }

    public static void main(String[] args) {
        A<Integer> a = new A<>(0);
        System.out.println(a.get());

        A<String> aa = new A<>("hello");
        System.out.println(aa.get());

    }
}