public abstract class Student {

    private String name;
    private Student next;

    public Student(String name){
        this.name = name;
    }

    public abstract boolean resolve(Homework hw);

    public void tryHomework(Homework hw){
        boolean solved = resolve(hw);

        if(solved){
            System.out.println(name + " solved " + hw);
        }else{
            if(next != null){
                next.tryHomework(hw);
            }else{
                System.out.println("No one solve " + hw);
            }
        }
    }

    public void setNext(Student next) {
        this.next = next;
    }
}
