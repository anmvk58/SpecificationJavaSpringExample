package com.anmv.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Department")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "`name`", length = 50, nullable = false, unique = true)
    @NonNull
    private String name;

    @Column(name = "total_member")
    private int totalMember;

    @Column(name = "`type`", nullable = false)
    @Convert(converter = DepartmentTypeConvert.class)
    private Type type;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdDate;

    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

    public enum Type {
        DEV("Dev"), TEST("Test"), ScrumMaster("ScrumMaster"), PM("PM");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Type toEnum(String sqlValue) {
            for (Type type : Type.values()) {
                if (type.getValue().equals(sqlValue)) {
                    return type;
                }
            }
            return null;
        }

    }

}

