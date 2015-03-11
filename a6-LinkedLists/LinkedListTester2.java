/**
 * A tester for a6-LinkedList
 * @author unknown -> from anonymous author on piazza (reference: @288)
 */

import java.util.Iterator;

public class LinkedListTester2 {

    public static void main(String[] args) {
    	insertTests();
    	addTests();
    	setTests();
    	getTests();
        removeTests();
        iteratorTests();
        sublistsTest();
        sizeTest();
        indexOfTest();
        makeEmptyTest();
        removeRangeTest();
        firstAndLastTest();
        equalsTest();
    }

    private static interface Executable { void run(); }

    private static void assertException(Executable exec, String testName) {
        try {
            exec.run();
            System.out.println("*******Failed test: " + testName);
            System.out.println("       Expected a thrown exception");
            throw new RuntimeException("Failed test: " + testName);
        } catch (Exception ex) {
            System.out.println("Passed test: " + testName);
        }
    }

    private static void assertEquals(Object o1, Object o2, String testName) {
        if (!o1.equals(o2)) {
            System.out.println("*******Failed test: " + testName);
            System.out.println("       " + o1 + " does not equal " + o2);
            throw new RuntimeException("Failed test: " + testName);
        }

        System.out.println("Passed test: " + testName);
    }

    private static void equalsTest() {
        final String testName = "Equals test #";
        final LinkedList<Integer> llist1 = new LinkedList<>();
        final LinkedList<Integer> llist2 = new LinkedList<>();

        int[] elements1 = {1, 2, 3, 4};
        int[] elements2 = {4, 2, 3, 1};

        for (int i = 0; i < 4; i++) {
            llist1.add(elements1[i]);
            llist2.add(elements2[i]);
        }

        assertEquals(false, llist1.equals(llist2), testName + 1);
        llist1.removeFirst();
        llist2.removeFirst();
        llist2.removeLast();
        assertEquals(false, llist1.equals(llist2), testName + 2);
        llist1.removeLast();
        assertEquals(true, llist1.equals(llist2), testName + 3);
        llist1.makeEmpty();
        llist2.makeEmpty();
        assertEquals(true, llist1.equals(llist2), testName + 4);
        assertEquals(false, llist1.equals(null), testName + 5);
        assertEquals(false, llist1.equals("[]"), testName + 6);
    }

    private static void firstAndLastTest() {
        final String testName = "FirstAndLast test #";
        final LinkedList<Integer> llist = new LinkedList<>();

        llist.addFirst(1);
        llist.addFirst(0);
        assertEquals("[0, 1]", llist.toString(), testName + 1);
        assertEquals(2, llist.size(), testName + 2);
        llist.addLast(2);
        llist.addLast(3);
        assertEquals("[0, 1, 2, 3]", llist.toString(), testName + 3);
        assertEquals(4, llist.size(), testName + 4);
        llist.removeFirst();
        llist.removeLast();
        assertEquals("[1, 2]", llist.toString(), testName + 5);
        assertEquals(2, llist.size(), testName + 6);
        llist.removeFirst();
        llist.removeLast();
        assertEquals("[]", llist.toString(), testName + 7);
        assertEquals(0, llist.size(), testName + 8);

        assertException(new Executable() {
            public void run() {
                llist.removeLast();
            }
        }, testName + 9);

        assertException(new Executable() {
            public void run() {
                llist.removeFirst();
            }
        }, testName + 10);

    }

    private static void removeRangeTest() {
        final String testName = "RemoveRange test #";
        final LinkedList<Integer> llist = new LinkedList<>();
        for (int i = 0; i < 5; i++)
            llist.add(i);

        IList<Integer> test = llist.getSubList(0, 5);
        test.removeRange(0, 5);
        assertEquals("[]", test.toString(), testName + 1);
        test = llist.getSubList(0, 5);
        test.removeRange(1, 5);
        assertEquals("[0]", test.toString(), testName + 2);
        test = llist.getSubList(0, 5);
        test.removeRange(0, 4);
        assertEquals("[4]", test.toString(), testName + 3);
        assertEquals(1, test.size(), testName + 4);
        test = llist.getSubList(0, 5);
        test.removeRange(0, 0);
        assertEquals("[0, 1, 2, 3, 4]", test.toString(), testName + 5);

        assertException(new Executable() {
            public void run() {
                IList<Integer> test = llist.getSubList(0, 5);
                test.removeRange(-1, 1);
            }
        }, testName + 6);

        assertException(new Executable() {
            public void run() {
                IList<Integer> test = llist.getSubList(0, 5);
                test.removeRange(0, 6);
            }
        }, testName + 7);

        assertException(new Executable() {
            public void run() {
                LinkedList<Integer> empty = new LinkedList<>();
                empty.removeRange(0, 0);
            }
        }, testName + 8);

    }

    private static void makeEmptyTest() {
        final String testName = "MakeEmpty test #";
        final LinkedList<Integer> llist = new LinkedList<>();

        llist.add(0);
        llist.makeEmpty();
        assertEquals("[]", llist.toString(), testName + 1);
        llist.makeEmpty();
        assertEquals("[]", llist.toString(), testName + 2);
        assertEquals(0, llist.size(), testName + 3);
    }

    private static void indexOfTest() {
        final String testName = "IndexOf test #";
        final LinkedList<Integer> llist = new LinkedList<>();
        int[] elements = {0, 1, 2, 3, 4, 3, 3};
        for (int e : elements)
            llist.add(e);

        assertEquals(llist.indexOf(3), 3, testName + 1);
        assertEquals(llist.indexOf(0), 0, testName + 2);
        assertEquals(llist.indexOf(4), 4, testName + 3);
        assertEquals(llist.indexOf(5), -1, testName + 4);
        assertEquals(llist.indexOf(4, 4), 4, testName + 5); //indexOf(int item, int pos)
        assertEquals(llist.indexOf(4, 5), -1, testName + 6);
        assertEquals(llist.indexOf(3, 4), 5, testName + 7);

        assertException(new Executable() {
            public void run() {
                llist.indexOf(null);
            }
        }, testName + 8);

        assertException(new Executable() {
            public void run() {
                llist.indexOf(0, -1);
            }
        }, testName + 9);

        assertException(new Executable() {
            public void run() {
                llist.indexOf(0, 7);
            }
        }, testName + 10);
    }

    private static void sizeTest() {
        String testName = "Size test #";
        LinkedList<Integer> llist = new LinkedList<>();

        assertEquals(0, llist.size(), testName + 1);
        llist.add(1);
        assertEquals(1, llist.size(), testName + 2);
        llist.add(2);
        assertEquals(2, llist.size(), testName + 3);
        llist.remove(0);
        assertEquals(1, llist.size(), testName + 4);
        llist.remove(0);
        assertEquals(0, llist.size(), testName + 5);
    }

    private static void sublistsTest() {
        String testName = "SubLists test #";
        final LinkedList<Integer> llist = new LinkedList<>();
        for (int i = 0; i < 4; i++)
            llist.add(i);

        assertEquals("[0, 1, 2, 3]", llist.getSubList(0, 4).toString(), testName + 1);
        assertEquals("[1, 2, 3]", llist.getSubList(1, 4).toString(), testName + 2);
        assertEquals("[0, 1, 2]", llist.getSubList(0, 3).toString(), testName + 3);
        assertEquals("[1, 2]", llist.getSubList(1, 3).toString(), testName + 4);
        assertEquals("[0]", llist.getSubList(0, 1).toString(), testName + 5);
        assertEquals("[]", llist.getSubList(0, 0).toString(), testName + 6);

        assertException(new Executable() {
            public void run() {
                llist.getSubList(1, 0);
            }
        }, testName + 7);
        /*
         * Following test is invalid as of @306 on piazza)
        assertException(new Executable() {
            @Override
            public void run() {
                LinkedList<Integer> empty = new LinkedList<>();
                empty.getSubList(0, 0);
            }
        }, testName + 8);
        */
    }

    private static void iteratorTests() {
        String testName = "Iterator test #";
        LinkedList<Integer> llist = new LinkedList<>();
        for (int i = 0; i < 8; i++)
            llist.add(i);

        final Iterator<Integer> it1 = llist.iterator();
        for (int i = 0; i < 8; i++) {
            assertEquals(true, it1.hasNext(), testName + (2 * i + 1)); //tests 1, 3, 5, 7, 9, 11, 13, 15
            assertEquals(i, it1.next(), testName + (2 * i + 2)); //tests 2, 4, 6, 8, 10, 12, 14, 16
            if (i % 2 == 0)
                it1.remove();
        }
        assertEquals("[1, 3, 5, 7]", llist.toString(), testName + 17);
        assertEquals(4, llist.size(), testName + 18);

        final Iterator<Integer> it2 = llist.iterator();
        while (it2.hasNext()) {
            it2.next();
            it2.remove();
        }
        assertEquals(0, llist.size(), testName + 19);
        assertEquals("[]", llist.toString(), testName + 20);
        assertEquals(false, it2.hasNext(), testName + 21);

        assertException(new Executable() {
            public void run() {
                it2.remove();
            }
        }, testName + 22);

        assertException(new Executable() {
            public void run() {
                it2.next();
            }
        }, testName + 23);
    }

    private static void removeTests() {
        String testName = "Remove test #";
        final LinkedList<Character> llist = new LinkedList<>();
        for (int i = 0; i < 7; i++)
            llist.add((char) ('a' + i));

        assertEquals("[a, b, c, d, e, f, g]", llist.toString(), testName + 1);
        assertEquals('a', llist.remove(0), testName + 2);
        assertEquals("[b, c, d, e, f, g]", llist.toString(), testName + 3);
        assertEquals(true, llist.remove(new Character('b')), testName + 4);
        assertEquals("[c, d, e, f, g]", llist.toString(), testName + 5);
        assertEquals(false, llist.remove(new Character('z')), testName + 6);
        assertEquals("[c, d, e, f, g]", llist.toString(), testName + 7);
        llist.remove(4);
        assertEquals("[c, d, e, f]", llist.toString(), testName + 8);
        llist.remove(new Character('f'));
        assertEquals("[c, d, e]", llist.toString(), testName + 9);
        llist.remove(1);
        llist.remove(new Character('e'));
        llist.remove(0);
        assertEquals("[]", llist.toString(), testName + 10);
        assertEquals(0, llist.size(), testName + 11);

        assertException(new Executable() {
            public void run() {
                llist.remove(0);
            }
        }, testName + 12);

        assertException(new Executable() {
            public void run() {
                llist.remove(null);
            }
        }, testName + 13);
    }

    private static void getTests() {
        String testName = "Get test #";
        final LinkedList<Integer> llist = new LinkedList<>();

        assertException(new Executable() {
            public void run() {
                llist.get(0);
            }
        }, testName + 1);

        for (int i = 0; i < 3; i++)
            llist.add(i);
        for (int i = 0; i < 3; i++)
            assertEquals(llist.get(i), i, testName + (i + 2));

        assertException(new Executable() {
            public void run() {
                llist.get(3);
            }
        }, testName + 5);
    }

    private static void setTests() {
        String testName = "Set test #";
        final LinkedList<Integer> llist = new LinkedList<>();

        assertException(new Executable() {
            public void run() {
                llist.set(0, 0);
            }
        }, testName + 1);

        llist.add(0);
        llist.add(1);
        llist.add(2);

        llist.set(0, 3);
        assertEquals(llist.toString(), "[3, 1, 2]", testName + 2);
        llist.set(1, 4);
        assertEquals(llist.toString(), "[3, 4, 2]", testName + 3);
        llist.set(2, 5);
        assertEquals(llist.toString(), "[3, 4, 5]", testName + 4);

        assertException(new Executable() {
            public void run() {
                llist.set(3, 0);
            }
        }, testName + 5);

        assertException(new Executable() {
            public void run() {
                llist.set(1, null);
            }
        }, testName + 6);
    }

    private static void addTests() {
        final String testName = "Add test #";
        final LinkedList<Integer> llist = new LinkedList<>();

        llist.add(0);
        assertEquals("[0]", llist.toString(), testName + 1);
        llist.add(1);
        assertEquals("[0, 1]", llist.toString(), testName + 2);
        llist.add(2);
        assertEquals("[0, 1, 2]", llist.toString(), testName + 3);
        assertEquals(3, llist.size(), testName + 4);

        assertException(new Executable() {
            public void run() {
                llist.add(null);
            }
        }, testName + 5);
    }

    private static void insertTests() {
        final String testName = "Insert test #";
        final LinkedList<Integer> llist = new LinkedList<>();

        assertEquals(llist.toString(), "[]", testName + 1);
        llist.insert(0, 2);
        assertEquals(llist.toString(), "[2]", testName + 2);
        llist.insert(0, 0);
        assertEquals(llist.toString(), "[0, 2]", testName + 3);
        llist.insert(1, 1);
        assertEquals(llist.toString(), "[0, 1, 2]", testName + 4);
        llist.insert(3, 3);
        assertEquals(llist.toString(), "[0, 1, 2, 3]", testName + 5);
        assertEquals(llist.size(), 4, testName + 6);


        assertException(new Executable() {
            public void run() {
                llist.insert(-1, -1);
            }
        }, testName + 7);

        assertException(new Executable() {
            public void run() {
                llist.insert(5, -1);
            }
        }, testName + 8);

        assertException(new Executable() {
            public void run() {
                llist.insert(0, null);
            }
        }, testName + 9);
    }
}