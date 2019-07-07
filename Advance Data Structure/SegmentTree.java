public class SegmentTree {

    int[] data;
    int[] segmentTree;

    SegmentTree(int[] data){
        this.data = data;
        int height = (int)Math.ceil(Math.log(data.length)/Math.log(2));
        this.segmentTree = new int[(int)Math.pow(2,height) * 2 - 1];
    }

    void buildTree(int node, int start, int end) {
        if (start == end) {
            segmentTree[node] = data[start];
        } else {
            int mid = (end-start) / 2 + start;
            buildTree(2 * node + 1, start, mid);
            buildTree(2 * node + 2, mid + 1, end);
            segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
        }
    }

    int query(int node, int qstart, int qend, int low, int high){
        if(qend<low||qstart>high){
            return 0;
        }

        if(low<=qstart && qend>=high){
            return segmentTree[node];
        }

        int mid = (high-low)/2 + low;
        int firstHalf = query(node*2+1,qstart,qend,low,mid);
        int secondHalf = query(node*2+2,qstart,qend,mid+1,high);
        return firstHalf+secondHalf;
    }

    void update(int node, int value, int index, int low, int high){

        if(low==high){
            data[index] = value;
            segmentTree[node]=value;
            return;
        }
        int mid = (high-low)/2 + low;
        if(low<=index&&mid>=index){
            update(node*2+1,value,index,low,mid);
        } else {
            update(node*2+2,value,index,mid+1,high);
        }
        segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
    }

    public static void main(String[] args){
        int[] data = {-1,7,9,3,8,4};
        SegmentTree segmentTree = new SegmentTree(data);
        segmentTree.buildTree(0,0,data.length-1);
        System.out.println(segmentTree.query(0,0,5,0,data.length-1));
        segmentTree.update(0,0,0,0,data.length-1);
        System.out.println(segmentTree.query(0,0,5,0,data.length-1));

    }

}
