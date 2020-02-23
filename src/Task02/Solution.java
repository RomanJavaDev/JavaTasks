package Task02;

public class Solution implements Action {
    public static int countActionObjects;

    private int param;

    private Action solutionAction = new Action() {
        //!!!!! Изменения могут быть тут

        public void someAction() {
            //!!!!! Все изменения должны быть только тут
            FirstClass firstClass;
            SecondClass secondClass = new SecondClass();

            if (param > 0) {
                firstClass = new FirstClass() {
                    @Override
                    public Action getDependantAction() {
                        while (param > 0) {
                            System.out.println(param--);
                        }

                        super.someAction();

                        return new Action() {
                            @Override
                            public void someAction() {

                            }
                        };
                    }
                };
                firstClass.getDependantAction();

            }
            secondClass.someAction();
            System.out.println(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM.replaceAll("\n", "") + param);

        }
    };


    public Solution(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }


    public static void main(String[] args) {
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}

