public class CircularList
{
    private Node head;

    public CircularList()
    {
        head = null;
    }

    public void printForward() //Prints elements starting from the head and going forward
    {
        if (head != null)
        {
            Node itr = head;
            int pass = 0;
            boolean again = false;

            while (!again)
            {
                if (itr.equals(head))
                {
                    pass++;

                    if (pass > 1)
                    {
                        again = true;
                    }
                    else
                    {
                        System.out.print(itr.getVal() + " ");
                        itr = itr.getNext();
                    }
                }
                else
                {
                    System.out.print(itr.getVal() + " ");
                    itr = itr.getNext();
                }
            }
        }
        else
        {
            System.out.print("\nLIST IS EMPTY...\n");
        }
    }

    public void printBackward() //Prints elements starting from the end of the list and going backward
    {
        if (head != null)
        {
            Node itr = head.getPrev();
            boolean repeat = false;

            while (!repeat)
            {
                if (itr.equals(head))
                {
                    repeat = true;
                    System.out.print(itr.getVal() + " ");
                }
                else
                {
                    System.out.print(itr.getVal() + " ");
                    itr = itr.getPrev();
                }
            }
        }
        else
        {
            System.out.print("\nLIST IS EMPTY...\n");
        }
    }

    public void doublePrint() //Prints elements twice to demonstrate circular list
    {
        if (head != null)
        {
            Node itr = head;
            int pass = 0;
            boolean again = false;

            while (!again)
            {
                if (itr.equals(head))
                {
                    pass++;

                    if (pass > 2) //Performs two traversals
                    {
                        again = true;
                    }
                    else
                    {
                        System.out.print(itr.getVal() + " ");
                        itr = itr.getNext();
                    }
                }
                else
                {
                    System.out.print(itr.getVal() + " ");
                    itr = itr.getNext();
                }
            }
        }
        else
        {
            System.out.print("\nLIST IS EMPTY...\n");
        }
    }

    public void addElement(int newVal)
    {
        if (head == null)
        {
            head = new Node(newVal);
            head.setNext(head);
            head.setPrev(head);
        }
        else
        {
            Node addThis = new Node(newVal);
            Node search = head;

            boolean foundPlace = false;
            boolean duplicate = false;

            while (!foundPlace && !duplicate)
            {
                if (search.getVal() == addThis.getVal())
                {
                    duplicate = true;
                }
                else
                {
                    if (search.getVal() > addThis.getVal())
                    {
                        if (search == head && search.getNext() == head) //Checks if 'head' is the only element in the list
                        {
                            head = addThis; //Smallest element becomes the new head
                            foundPlace = true;

                            head.setNext(search);
                            head.setPrev(search.getPrev());
                            head.getPrev().setNext(head);
                            head.getNext().setPrev(head);
                        }
                        else //Add to list
                        {
                            foundPlace = true;

                            addThis.setNext(search);
                            addThis.setPrev(search.getPrev());
                            addThis.getPrev().setNext(addThis);
                            addThis.getNext().setPrev(addThis);
                        }
                    }
                    else
                    {
                        if (search == head && search.getNext() == head) //Checks if 'head' is the only element in the list
                        {
                            foundPlace = true;

                            search.setNext(addThis);
                            search.setPrev(addThis);
                            addThis.setNext(search);
                            addThis.setPrev(search);
                        }
                        else if (search != head && search.getNext() == head) //Checks if search is at the end of the list
                        {
                            foundPlace = true;

                            addThis.setNext(search.getNext());
                            addThis.setPrev(search);
                            search.getNext().setPrev(addThis);
                            search.setNext(addThis);
                        }
                        else //Keep searching (increment iterator to next node in list)
                        {
                            search = search.getNext();
                        }
                    }
                }
            }
        }
    }
}
