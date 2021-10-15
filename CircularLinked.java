public class CircularLinked
{
    public static void main(String[] args)
    {
        CircularList test = new CircularList();

        int[] arr = {8, 1, 10, 2, 7, 11,  5, 9, 4, 3, 12, 6};

        for (int i = 0; i < arr.length; i++)
        {
            test.addElement(arr[i]);
        }

        System.out.print("Forward: ");
        test.printForward(); //Tests forward traversal
        System.out.print("\n");
        System.out.print("Backward: ");
        test.printBackward(); //Tests backward traversal
        System.out.print("\n");
        System.out.print("Double Print: ");
        test.doublePrint();
    }
}
