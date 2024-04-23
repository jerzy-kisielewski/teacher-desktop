module com.teacherdesktop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.json;

    opens com.teacherdesktop to javafx.fxml;
    exports com.teacherdesktop;
}