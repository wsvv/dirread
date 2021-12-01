package dirread;

/**
 *
 * @author yecq
 */
public class PcbInfo {

    private int pid;
    private int ppid;
    private String name;

    public PcbInfo(int pid, int ppid, String name) {
        this.pid = pid;
        this.ppid = ppid;
        this.name = name;
    }

    public PcbInfo() {

    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPpid() {
        return ppid;
    }

    public void setPpid(int ppid) {
        this.ppid = ppid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
