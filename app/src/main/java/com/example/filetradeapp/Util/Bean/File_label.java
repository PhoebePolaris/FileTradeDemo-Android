package com.example.filetradeapp.Util.Bean;

public class File_label {
    private String file_id;
    private String label_1;
    private String label_2;
    private String label_3;

    public String getFile_id() {
        return file_id;
    }

    public String getLabel_1() {
        return label_1;
    }

    public String getLabel_2() {
        return label_2;
    }

    public String getLabel_3() {
        return label_3;
    }

    public void setFile_id(String user_id) {
        this.file_id = user_id;
    }

    public void setLabel_1(String label_1) {
        this.label_1 = label_1;
    }

    public void setLabel_2(String label_2) {
        this.label_2 = label_2;
    }

    public void setLabel_3(String label_3) {
        this.label_3 = label_3;
    }

    @Override
    public String toString() {
        return "File_label [file_id=" + file_id + ", label_1="+label_1+", label_2="+label_2+", label_3=" + label_3 + "]";
    }
}
