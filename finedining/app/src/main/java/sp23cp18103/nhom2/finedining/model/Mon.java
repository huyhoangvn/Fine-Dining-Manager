package sp23cp18103.nhom2.finedining.model;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Mon {
    private int maMon;
    private int maLM;
    private String tenMon;
    private int trangThai; // 1:"Dùng"; 0:"Không dùng"
    private byte[] hinh;

    public Mon(int maMon, int maLM, String tenMon, int trangThai, byte[] hinh) {
        this.maMon = maMon;
        this.maLM = maLM;
        this.tenMon = tenMon;
        this.trangThai = trangThai;
        this.hinh = hinh;
    }

    public Mon() {
    }

    public int getMaMon() {
        return maMon;
    }

    public void setMaMon(int maMon) {
        this.maMon = maMon;
    }

    public int getMaLM() {
        return maLM;
    }

    public void setMaLM(int maLM) {
        this.maLM = maLM;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public byte[] getHinh() {
        return hinh;
    }

    public void setHinh(byte[] hinh) {
        this.hinh = hinh;
    }

    /*
     * Trả về tên của trạng thái
     * 1:"Dùng"; 0:"Không dùng"
     * */
    public String getTenTrangThai(){
        return (this.trangThai == 1) ? "Dùng" : "Không Dùng";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mon mon = (Mon) o;
        return maMon == mon.maMon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maMon);
    }

    @NonNull
    @Override
    public String toString() {
        return getTenMon();
    }
}
