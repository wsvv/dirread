package dirread;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author kxqian
 * @author vv
 */
public class Main {

    public static void main(String[] args) {
        PcbInfoReader reader = new PcbInfoReader();
        String dir = "";
        dir = "/proc";
        

        List<PcbInfoNode> allProccess = new ArrayList<PcbInfoNode>();
        // 解析读入文件
        String[] files = reader.readNumericDir(dir);
        
        for (String file : files) {
        	
        	String fileDir = "";
            fileDir = "/proc/"+file+"/status";
        	
            PcbInfo info = new PcbInfoReader().readProcessInfoFromFile(fileDir);
        	PcbInfoNode infoNode =new PcbInfoNode(info);
            allProccess.add(infoNode);
        }
        
        // 递归解析父子关系
        List<PcbInfoNode> tree = listToTree(allProccess);
        
        System.out.println(tree.get(0).toLogString());
        
    }
    

    public static List<PcbInfoNode> listToTree(List<PcbInfoNode> list) {
        // 用递归找子
        List<PcbInfoNode> treeList = new ArrayList<PcbInfoNode>();
        for (PcbInfoNode tree : list) {
            if (tree.info.getPid() == 1) {
            	tree.tab_holder = "                                                                                                   ".substring(0, (tree.info.getName()+String.valueOf(tree.info.getPid())).length());
//            	tree.next_tab = "                                                                                                   ".substring(0, (tree.info.getName()+String.valueOf(tree.info.getPid())).length());
//            	System.out.println(tree.info.getName()+"("+tree.info.getPid()+")"+"-+-");
                treeList.add(findChildren(tree, list, tree.tab_holder.length()));  //递归添加孩子
            }
        }
        return treeList;
    }
 
    private static PcbInfoNode findChildren(PcbInfoNode tree, List<PcbInfoNode> list,int tabLength) {
        for (PcbInfoNode node : list) {
            if (node.info.getPpid() == tree.info.getPid()) {
            	node.tab_holder = "                                                                                                   ".substring(0, tabLength+(node.info.getName()+String.valueOf(node.info.getPid())).length()+3);
                tree.addChild(findChildren(node, list, tabLength +(node.info.getName()+String.valueOf(node.info.getPid())).length()+3));
            }
        }
        return tree;
    }
    
    
}


