package com.coding.interviw.TreesAndGraph;

import com.coding.interviw.TreesAndGraph.RandomNode.BinaryTree;

import javax.swing.tree.TreeNode;
import java.util.*;

public class TreeAndGraphApp {

    public static void main(String...args){

        /*

                     50
                    /  \
                  30    70
                 / \    / \
               20   40 60  80


         */

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);
        binarySearchTree.insert(70);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);

        // print inorder travesal of the BST
        System.out.println("Inorder");
        binarySearchTree.inorder();

        System.out.println("Preorder");
        binarySearchTree.preorder();

        System.out.println("Postorder");
        binarySearchTree.postorder();

        // find value
        System.out.println("search");
        binarySearchTree.searchNodeValue();

        System.out.println("BFS");
        binarySearchTree.bfsRec();


        // Graph Datastructure
        Graph myGraph = new Graph(5);
        myGraph.addEdge(0,1);
        myGraph.addEdge(0,2);
        myGraph.addEdge(0,3);
        myGraph.addEdge(1,2);
        myGraph.addEdge(1,4);
        myGraph.addEdge(2,3);
        myGraph.addEdge(3,1);
        myGraph.addEdge(4,0);
        myGraph.addEdge(4,3);

        Object [] values = myGraph.getEdge(0);
        for(Object value : values){
            System.out.println(value);
        }

        // Trie Datastructure

        /* Input keys (use only  'a' through 'z' and lower case) */
        String[] keys = {"the", "a", "there", "answer","any","by","bye","their"};

        String [] output = {"Not present in trie", "Present in trie"};

        for (int i = 0; i < keys.length ; i++) {
            Trie.insert(keys[i]);
        }

        // Search for different keys
        if(Trie.search("the")){
            System.out.println("the-------- "+ output[1]);
        }


 /* minimal Tree */
       Node nodeMin = createMinimalBST(new int[]{1,2,3,4,5,6});

      createLevelLinkedList2(nodeMin);

      /* Check Balanced */

      // balanced
      Node node1 = new Node(1);
      Node node2 = new Node(2);
      Node node3 = new Node(3);
      Node node4 = new Node(4);

      node1.left = node2;
      node2.right =node4;
      node1.right = node3;

      // unbalanced
        Node node5 = new Node(1);
        Node node6 = new Node(2);
        Node node7 = new Node(3);
        Node node8 = new Node(4);
        Node node9 = new Node(4);

        node5.left = node6;
        node6.right =node7;
        node7.right = node8;
        node5.right =node9;

        Node node10 = new Node(20);
        Node node11 = new Node(10);
        Node node12 = new Node(30);
        Node node13 = new Node(25);

        node10.left =  node11;
        node10.right = node12;
        node11.right = node13;
        

        boolean isBalanced = checkBst2(node10,null,null);

        /* isBinary search tree */
        boolean isBinarysearchTree = isBinarySearchTree(nodeMin);

        /* Successor */

        /* Prueba uno */
          NodeWithParent node14 = new NodeWithParent(20);

          NodeWithParent node15 = new NodeWithParent(11);
          NodeWithParent node16 = new NodeWithParent(9);
          NodeWithParent node17 = new NodeWithParent(5);
          NodeWithParent node18 = new NodeWithParent(10);
          NodeWithParent node19 = new NodeWithParent(13);
          NodeWithParent node20 = new NodeWithParent(12);
          NodeWithParent node21 = new NodeWithParent(14);

          NodeWithParent node22 = new NodeWithParent(23);
          NodeWithParent node23 = new NodeWithParent(21);
          NodeWithParent node24 = new NodeWithParent(34);

          node14.left = node15;
          node15.parent = node14;
          node15.left = node16;
          node16.parent = node15;
          node16.left = node17;
          node16.right =node18;
          node17.parent = node16;
          node18.parent = node16;

          node15.right = node19;
          node19.parent = node15;
          node19.left = node20;
          node20.parent = node19;
          node19.right = node21;
          node21.parent = node19;

          node14.right = node22;
          node22.parent = node14;
          node22.left = node23;
          node23.parent = node22;
          node22.right = node24;
          node24.parent = node22;


         NodeWithParent succesor =  inorderSucc(node21);

         NodeWithParent predessor = predessor(node24);

         NodeWithParent commonAncestor = commonAncestor(node22,node24);

        NodeWithParent commonAncestor2 = commonAncestor2(node17,node15);

        NodeWithParent  commonAncestor5 = commonAncestor5(node14,node20,node21);

        List<Integer>[] sequencies = new ArrayList[2];
        bstSequence(node14, sequencies);
        List<LinkedList<Integer>> secuences = allSequences(node14);


        //secondTree
        NodeWithParent no1 = new NodeWithParent(10);
        NodeWithParent no2 = new NodeWithParent(4);
        NodeWithParent no3 = new NodeWithParent(6);
        NodeWithParent no4 = new NodeWithParent(30);

        no1.left = no2;
        no1.right = no3;
        no2.left = no4;


        // First tree
        NodeWithParent no5 = new NodeWithParent(26);

        NodeWithParent no7 = new NodeWithParent(3);
        NodeWithParent no8 = new NodeWithParent(3);
        no7.left = no8;
        no5.left= no1;
        no5.right = no7;

        // Is subtree
        boolean subtree = containsTree2(no5,no1);

        int maxHeigh = ReferenceExercices.getMaxHeight(node14);


        // vertical Order
        String verticaloder =  ReferenceExercices.printOrder(node14);
        //Random node
        NodeWithParent random = BinaryTree.randomNode(node14,new ArrayList<NodeWithParent>());
        NodeWithParent deleteNode = BinaryTree.deleteNode(node14,9);

        // BFS Level by level
        ReferenceExercices.bfsLevelByLevel(node14);

         // Build Order
        Graph graph = new Graph(6);
        graph.addEdge(0,'d');
        graph.addEdge(1,'d');
        graph.addEdge(3,'c');
        graph.addEdge(5,'a');
        graph.addEdge(5,'b');

    }

    /* minimal Tree */

    static Node createMinimalBST(int [] arr){
        return createMinimalBST(arr,0, arr.length - 1);
    }
    static Node createMinimalBST(int [] arr, int start, int end){
        if(end < start){
           return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);
        node.left = createMinimalBST(arr, start, mid -1);
        node.right = createMinimalBST(arr, mid+1, end);
        return node;
    }

    static void createLevelLinkedList(Node root, ArrayList<LinkedList<Node>> lists, int level){
        if(root == null){
            return;
        }
        LinkedList<Node> list = null;
        if(lists.size() == level){ // level not contained in list
            list = new LinkedList<>();
            /*
            Levels are always traversed in order. So, if this is the first time we've
            visited level i, we must have seen levels 0 through i-1. We can
            therefore safely add the level at the end
             */
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists,level+1);
        createLevelLinkedList(root.right, lists, level + 1);
    }

    static ArrayList<LinkedList<Node>> createLevelLinkedList(Node root){
        ArrayList<LinkedList<Node>> lists = new ArrayList<>();
        createLevelLinkedList(root,lists, 0);
        return lists;
    }

    private static List<LinkedList<Node>> createLevelLinkedList2(Node root){
        ArrayList<LinkedList<Node>> result = new ArrayList<>();
        /* Visit the root*/
        LinkedList<Node> current = new LinkedList<>();
        if(root != null){
            current.add(root);
        }
        while(current.size() > 0){
            result.add(current); // Add previous level
            LinkedList<Node> parents = current;// Go to next level
            current = new LinkedList<Node>();
            for(Node parent: parents){
                /* Visit the children */
                if(parent.left != null){
                    current.add(parent.left);
                }
                if(parent.right != null){
                    current.add(parent.right);
                }
            }
        }
        return result;
    }

    private static boolean isBalanceBinaryTree(Node root){
        LinkedList<Node> rightResult  = new LinkedList<>();
        LinkedList<Node> leftResult  = new  LinkedList<>();
        LinkedList<Node> current = new LinkedList<>();

        if(root != null){
            current.add(root);
        }

        while(current.size() > 0){
            LinkedList<Node> parents = current;
            current = new LinkedList<>();
            for(Node parent: parents){
                if(parent.left != null){
                    leftResult.add(parent.left);
                    current.add(parent.left);
                }
                if(parent.right != null){
                    rightResult.add(parent.right);
                    current.add(parent.right);
                }
            }
        }
        return Math.abs(rightResult.size() - leftResult.size()) < 2;
    }

   static boolean isBalanced(Node root){
          if(root == null) return true;  // Base case

          int heightDiff = getHeight(root.left) - getHeight(root.right);
          if(Math.abs(heightDiff)>1){
             return false;
          } else{   // Recurse
              return isBalanced(root.left)  && isBalanced(root.right);
          }
   }

   static int getHeight(Node root){
         if(root == null)  return -1;
         return Math.max(getHeight(root.left),getHeight(root.right)) +1;
   }

   static boolean isBalancedBetter(Node root){
       return checkHeight(root) != Integer.MIN_VALUE;
   }
   static int  checkHeight(Node root){
        if(root == null) return -1;

        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up

        int rightHeight = checkHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE; // Pass error up

        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1){
           return Integer.MIN_VALUE; // Found error -> pass it back
        }else{
            return Math.max(leftHeight, rightHeight)+1;
        }
   }

    static boolean isBinarySearchTree(Node root){

       if(root.left != null){
           if(root.left.key <= root.key){
                isBinarySearchTree(root.left);
           }
           if(root.left.key > root.key){
               return false;
           }
       }

        if(root.right != null){
            if(root.right.key > root.key){
                 isBinarySearchTree(root.right);
            }
            if(root.right.key < root.key){
                return false;
            }
        }

        return true;
    }

    static Integer last_printed = null;
    static boolean checkBst(Node node){
         if(node == null){
             return true;
         }

         // Check / recurse left
        if(!checkBst(node.left)) {
            return false;
        }

        // Check current
        if(last_printed != null && node.key <= last_printed){
           return false;
        }
        last_printed = node.key;

        // Check / recurse right

        if(!checkBst(node.right)){
           return false;  
        }

        return true; // all good

    }

    static boolean checkBst2(Node node, Integer min, Integer max){
       if(node == null){
           return true;
       }
       if((min != null && node.key <= min) || (max != null && node.key > max)){
          return false;
       }
       if(!checkBst2(node.left, min, node.key) || !checkBst2(node.right, node.key, max)){
          return false;
       }
       return true;
    }


    static NodeWithParent inorderSucc(NodeWithParent node){
       if(node == null){
           return null;
       }  

       /* Found right children -> return leftmost node of right subtree. */
       if(node.right != null){
          return leftMostChild(node.right);
       }else{
           NodeWithParent q = node;
           NodeWithParent x = q.parent;

           // Go up until we're on left instead of right
           while(x != null && x.left != q){
              q = x;
              x = x.parent;
           }
           return x;
       }
    }

    static NodeWithParent leftMostChild(NodeWithParent node){
        if(node == null){
            return null;
        }
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    static NodeWithParent predessor(NodeWithParent node){

        if(node.left != null){
            return rightMostChild(node.left);
        }else{
            NodeWithParent q = node;
            NodeWithParent x= q.parent;

            while(x != null && x.right != q){
                q= x;
                x= x.parent;
            }
            return x;
        }
    }

    static NodeWithParent rightMostChild(NodeWithParent node){
        if(node == null){
            return null;
        }
        while(node.right != null){
            node = node.right;
        }
        return node;
    }

    // with Links to Parent
   static NodeWithParent commonAncestor(NodeWithParent first, NodeWithParent second){
        NodeWithParent firstRoot = first;
        NodeWithParent secondRoot = second;

        while(firstRoot != null) {
            firstRoot.isVisited = true;
            firstRoot = firstRoot.parent;
        }

       while(secondRoot != null) {
            if(secondRoot.isVisited){
                return secondRoot;
            }
           secondRoot.isVisited = true;
           secondRoot = secondRoot.parent;
       }
       return null;
    }

    // With Link to P
    //


    static NodeWithParent commonAncestor2 (NodeWithParent p, NodeWithParent q){
       int delta = depth(p) - depth(q); // get difference in depths
        NodeWithParent first = delta > 0 ? q : p; // get shallower node
        NodeWithParent second = delta > 0 ? p : q; // get deeper node
        second = goUpBy(second, Math.abs(delta));// move deeper node up

        /* Find where paths intersect */
        while(first != second && first != null && second != null){
            first = first.parent;
            second = second.parent;
        }
        return first == null || second == null ? null: first;
    }

    static NodeWithParent goUpBy(NodeWithParent node, int delta){
        while (delta > 0 && node != null){
            node = node.parent;
            delta --;
        }
        return node;
    }
    static int depth (NodeWithParent node){
        int depth = 0;
        while(node != null){
            node = node.parent;
            depth++;
        }
        return depth;
    }

    static NodeWithParent commonAncestor3(NodeWithParent root, NodeWithParent p, NodeWithParent q){
        /* Check if either node is not in the tree, or if one covers the order */
        if(!covers(root, p) || !covers(root,q)){
            return null;
        }else if(covers(p,q)){
            return p;
        }else if(covers(q,p)){
            return q;
        }
        /* Traverse upward until you find a node that covers q */
        NodeWithParent sibling = getSibling(p);
        NodeWithParent parent = p.parent;
        while(!covers(sibling, q)){
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }
    static boolean covers(NodeWithParent root, NodeWithParent p){
        if(root == null){
            return false;
        }
        if(root == p){
           return true;
        }
        return covers(root.left,p) || covers(root.right, p);
    }

    static NodeWithParent getSibling(NodeWithParent node){
        if(node == null || node.parent == null){
            return null;
        }
        NodeWithParent parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }

    /* Without Links to Parents

     */
    static NodeWithParent commonAncestor4(NodeWithParent root, NodeWithParent p, NodeWithParent q){
        /*  Error check - one node is not in the tree */
        if(!covers(root,p) || !covers(root,q) ){
            return null;
        }
        return ancestorHelper(root, p, q);
    }

    static NodeWithParent ancestorHelper(NodeWithParent root, NodeWithParent p, NodeWithParent q){
        if(root== null || root == p || root == q){
            return root;
        }

        boolean pIsOnLeft = covers(root.left, p);
        boolean qIsOnLest = covers(root.left, q);
        if(pIsOnLeft != qIsOnLest){ // Nodes are on different side
            return root;
        }
        NodeWithParent childSide = pIsOnLeft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }

    /* Without Links to Parents

     */
   static NodeWithParent commonAncestor5(NodeWithParent root, NodeWithParent p, NodeWithParent q){
        if(root == null){
            return null;
        }
        if(root == p && root==q){
            return root;
        }

        NodeWithParent x = commonAncestor5(root.left,p,q);
        if(x != null && x != p && x != q){ // Already found ancestor
            return x;
        }

        NodeWithParent y = commonAncestor5(root.right,p,q);
        if(y != null && y != p && y != q){ // Already found ancestor
            return y;
        }

        if(x != null && y != null){ // p and q found in diff. subtrees
            return root; // This is the common ancestor
        }else if(root == p || root == q){
            return  root;
        }else{
            return x == null ? y : x; /* return the non-null value */
        }
   }

   static List<Integer>[] bstSequence(NodeWithParent node,List<Integer>[] sequencies ){
       for(int i =0; i<sequencies.length;i++){
           sequencies[i]=new ArrayList<>();
       }
       addLeftSequence(node,sequencies);
       addRigtSequence(node,sequencies);
       return  sequencies;
   }

   static  void addLeftSequence(NodeWithParent node,List<Integer>[] sequencie){
       if(node== null){
          return;
       }
       sequencie[0].add(node.key);
       addLeftSequence(node.left,sequencie);
       addLeftSequence(node.right,sequencie);
   }

    static  void addRigtSequence(NodeWithParent node,List<Integer>[] sequencies){
        if(node== null){
            return;
        }
        sequencies[1].add(node.key);
        addRigtSequence(node.right,sequencies);
        addRigtSequence(node.left,sequencies);
    }

   static List<LinkedList<Integer>> allSequences(NodeWithParent node){
        List<LinkedList<Integer>> result = new ArrayList<>();

        if(node == null){
           result.add(new LinkedList<Integer>());
           return result;
        }
        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.key);

        /* Recurse on left and right subtrees */
        List<LinkedList<Integer>> leftSeq = allSequences(node.left);
        List<LinkedList<Integer>> rightSeq = allSequences(node.right);

        /* Weave together each list from the left and right sides */
        for(LinkedList<Integer> left: leftSeq){
            for(LinkedList<Integer> right: rightSeq){
                List<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left,right,weaved,prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    /* Weave lists together in all possible ways. This algorithm works by removing the
    *  head from one list, recursing, and then doing the same thing with the other list
    * */

    static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                           List<LinkedList<Integer>> results, LinkedList<Integer> prefix){
        /* One list is empty. Add remainder to [a cloned] prefix and store result. */
        if(first.size() == 0 || second.size() == 0){
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        /* Recurse with head of first added to the prefix. Removing the head will damage
         * first, so we'll need to put it back where we found it afterwards. */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        /* Do the same thing with second, damaging and then restoring the list*/
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first,second,results,prefix);
        prefix.removeLast();
        second.addFirst(headSecond);

    }

    // isSubtree
    static boolean containsTree(NodeWithParent t1, NodeWithParent t2){
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        getOrderString(t1, string1);
        getOrderString(t2, string2);

        return string1.indexOf(string2.toString()) != -1;
    }
    static void getOrderString(NodeWithParent node, StringBuilder sb){
        if(node == null){
            sb.append("X"); // Add null indicator
            return;
        }
        sb.append(node.key + " "); // Add root
        getOrderString(node.left,sb);
        getOrderString(node.right,sb);
    }

    static boolean containsTree2(NodeWithParent t1, NodeWithParent t2){
        if(t2 == null){
           return true;  // The empty tree is always a subtree
        }
        return subTree(t1,t2);
    }
    static boolean subTree(NodeWithParent r1, NodeWithParent r2){
        if(r1 == null){
            return false; // big tree empty & subtree still not found
        }else if(r1.key == r2.key && matchTree(r1,r2)){
            return true;
        }
        return subTree(r1.left,r2) || subTree(r1.right,r2);
    }
    static boolean matchTree(NodeWithParent r1, NodeWithParent r2){
        if(r1 == null && r2 == null){
            return true; // nothing left in the subtree
        }else if(r1 == null || r2 == null){
            return false; // exactly tree is empty, therefore trees don't match
        }else if(r1.key != r2.key){
            return false; // data doesn't match
        }else{
            return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
        }
    }

}


