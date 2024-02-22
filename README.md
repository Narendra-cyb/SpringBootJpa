# SpringBootJpa
### Embedded 
- Embedded means if I have a **Student** and **Guardian** class and I don't want to keep fields of two classes in one class, so to separate the classes but have them embedded in Student only. The class is separated, not features. So, to achieve this, let's create Student and Guardian classes.

**Student**

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="studentAlt",
            uniqueConstraints = @UniqueConstraint(name = "emailId_unique",columnNames = "emailId"))//here uniqueConstraints used for assigning a constraint to a pirticular Column
public class Student {

    @Id
    @SequenceGenerator(name = "student_seq",allocationSize = 1,sequenceName = "student_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    private Integer id;
    private String name;
    
    @Column(name = "emailId",nullable = false)
    private String email;
    private String college;
    
    @Embedded //keyword used for to embedded guardian class and in mention class @Embeddable should present in class
    private Guardian guardian;
}
```
**Guardian**
```java
@Embeddable // here it specify that this class is a embeddable class
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name = "guardian_name")), // here AttributeOverride work as to it'll replace the field name,email,mobile with guardian_name,guardianmail
        @AttributeOverride(name = "email",column = @Column(name = "guardian_mail")),
        @AttributeOverride(name = "mobile", column = @Column(name = "guardian_mobile"))
})
public class Guardian {
    private String name;
    private String email;
    private String mobile;
}
```

