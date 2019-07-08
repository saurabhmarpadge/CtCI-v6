class TrieNode {
        Map<Character,TrieNode> children;
        boolean isCompleteWord;
        int count;
        TrieNode(){
            count =0;
            isCompleteWord = false;
            children = new HashMap<>();
        }
        public void add(String contact){
            
            if(contact.isEmpty()){
                return;
            }
            if(contact.length()==1){
               this.isCompleteWord=true; 
            }
            this.count++;
            Character firstLetter = contact.charAt(0);
            if(!children.containsKey(firstLetter)){
                this.children.put(firstLetter,new TrieNode());
            }
            this.children.get(firstLetter).add(contact.substring(1));
        }

        public int findCount(String contact, TrieNode trieNode){
            if(contact.isEmpty()){
               return trieNode.count;
            }
            Character firstLetter = contact.charAt(0);
            if(!trieNode.children.containsKey(firstLetter)){
                return 0;    
            }
            return findCount(contact.substring(1),trieNode.children.get(contact.charAt(0)));
        }
    }


