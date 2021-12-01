package dirread;

import java.util.ArrayList;

class PcbInfoNode extends PcbInfo {
	public ArrayList<PcbInfoNode> children;  //Node孩子
	public PcbInfo info;       //Node信息
	public String tab_holder = "";      //缩进距离

    public PcbInfoNode(PcbInfo info) {
        this.info = info;
    }
	
    public void addChild(PcbInfoNode child) {
        if(null == this.children) {
        	this.children = new ArrayList<PcbInfoNode>();
        }
//        child.tab_holder = this.next_tab;
//        child.next_tab = "                                                                                                   ".substring(0, this.next_tab.length() + (this.info.getName()+this.info.getPid()).length()+3);
        this.children.add(child);
    }
    
    public String toLogString() {
        String str = ""+this.info.getName()+"("+this.info.getPid()+")"+"\n";
        if (this.children == null || this.children.size() < 1){
            return str;
        }
        for(int i=0;i<this.children.size();i++){
            str = str + this.tab_holder + "|--"+this.children.get(i).toLogString();
        }
        return str;
    	
    }
}