module com.example.teacherdesktop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.teacherdesktop to javafx.fxml;
    exports com.example.teacherdesktop;
}