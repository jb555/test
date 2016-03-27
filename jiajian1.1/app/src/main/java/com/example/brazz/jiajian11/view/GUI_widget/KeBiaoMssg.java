package com.example.brazz.jiajian11.view.GUI_widget;

/**
 * Created by BrazZ on 2016/2/28.
 */
public class KeBiaoMssg {
    public int WhichDay;
    public String Teacher;
    public String Place;
    public String CourseName;
    public int Section;//节次
    public int Jieshu;//节数
    public KeBiaoMssg(int WhichDay, String Teacher, String Place, String CourseName, int Section, int Jieshu)
    {
        this.WhichDay = WhichDay;
        this.CourseName = CourseName;
        this.Teacher = Teacher;
        this.Place = Place;
        this.Section = Section;
        this.Jieshu = Jieshu;
    }
    public KeBiaoMssg(String Teacher, String Place, String CourseName, int Section, int Jieshu)
    {
        this.CourseName = CourseName;
        this.Teacher = Teacher;
        this.Place = Place;
        this.Section = Section;
        this.Jieshu = Jieshu;
    }
  //  public
}
