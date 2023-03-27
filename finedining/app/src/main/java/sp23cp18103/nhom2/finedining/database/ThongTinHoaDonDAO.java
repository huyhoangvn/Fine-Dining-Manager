package sp23cp18103.nhom2.finedining.database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import sp23cp18103.nhom2.finedining.model.Ban;
import sp23cp18103.nhom2.finedining.model.Mon;
import sp23cp18103.nhom2.finedining.model.ThongTinHoaDon;

public class ThongTinHoaDonDAO {
    private SQLiteDatabase db;

    public ThongTinHoaDonDAO(Context context){
        DBHelper dbHelper =new DBHelper(context);
        db = dbHelper.getWritableDatabase();

    }

    public List<ThongTinHoaDon> getThongTinHoaDon(int maNV) {
        String sql = "SELECT hd.maHD,kh.tenKH,hd.soLuongKhach,hd.thoiGianXuat,hd.trangThai " +
                "FROM hoadon as hd " +
                "JOIN khachhang as kh ON hd.maKH = kh.maKH " +
                "JOIN nhanvien as nv ON nv.maNV = hd.maNV " +
                "WHERE nv.maNH = (SELECT nvht.maNH FROM nhanvien nvht WHERE nvht.maNV = ?) ";
        return getDaTa(sql, String.valueOf(maNV));
    }
    public List<ThongTinHoaDon> getTrangThaiHoaDon(int maNV, int trangThai, String tenKH){
        String sql = "SELECT hd.maHD,nv.tenNV,kh.tenKH,hd.soLuongKhach,hd.thoiGianXuat,hd.trangThai " +
                "FROM hoadon as hd " +
                "JOIN khachhang as kh ON hd.maKH = kh.maKH " +
                "JOIN nhanvien as nv ON nv.maNV = hd.maNV " +
                "WHERE nv.maNH = (SELECT nvht.maNH FROM nhanvien nvht WHERE nvht.maNV = ?) " +
                " AND hd.trangThai >= ? " +
                " AND  hd.trangThai <> 0 " +
                " AND kh.tenKH LIKE ? " +
                " ORDER BY hd.trangThai DESC, kh.tenKH ASC ";
        String tim = "%" + tenKH + "%";
        return getDaTa(sql, String.valueOf(maNV),String.valueOf(trangThai),tim);

    }



    @SuppressLint("Range")
    public List<ThongTinHoaDon> getDaTa(String sql, String...SelectArgs){
        List<ThongTinHoaDon> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,SelectArgs);
        while (c.moveToNext()){
            ThongTinHoaDon tthd =new ThongTinHoaDon();
            tthd.setMaHD(c.getInt(c.getColumnIndex("maHD")));
            tthd.setTenNhanVien(c.getString(c.getColumnIndex("tenNV")));
            tthd.setTenKhachHang(c.getString(c.getColumnIndex("tenKH")));
            tthd.setSoLuongKhachHang(c.getInt(c.getColumnIndex("soLuongKhach")));
            tthd.setThoiGianXuat(c.getString(c.getColumnIndex("thoiGianXuat")));
            tthd.setTrangThai(c.getInt(c.getColumnIndex("trangThai")));
            list.add(tthd);
        }
        return list;
    }
}
