package com.mawen.lambda.chapter04;

/**
 * 默认方法，类中重写方法的优先级高于默认方法
 */
public class DefaultMethodExample {

    public static void main(String[] args) {
        Parent parent = new ParentImpl();
        parent.welcome();

        Child child = new ChildImpl();
        child.welcome();

        parent = new OverridingParent();
        parent.welcome();

        child = new OverridingChild();
        child.welcome();
    }

    interface Parent {
        public void message(String body);

        public default void welcome() {
            System.out.println("Parent: Hi!");
        }

        public String getLastMessage();
    }

    public static class ParentImpl implements Parent {
        @Override
        public void message(String body) {
            System.out.println("ParentImpl: " + body);
        }

        @Override
        public String getLastMessage() {
            return "ParentImpl";
        }
    }

    interface Child extends Parent {
        @Override
        public default void welcome() {
            System.out.println("Child: Hi!");
        }
    }

    public static class ChildImpl implements Child {
        @Override
        public void message(String body) {

        }

        @Override
        public String getLastMessage() {
            return null;
        }
    }


    public static class OverridingParent extends ParentImpl {

        @Override
        public void welcome() {
            System.out.println("Class Parent: Hi!");
        }
    }

    public static class OverridingChild extends OverridingParent implements Child {

    }
}
