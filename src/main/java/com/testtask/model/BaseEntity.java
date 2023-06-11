package com.testtask.model;

import javax.persistence.*;
import java.io.Serializable;

/**Базовый класс для всех сущностей*/
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -1457298299730766024L;

    /**Идентификатор*/
    @Id
    @GeneratedValue(generator = "system-uuid")
    @org.hibernate.annotations.GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(length = 40)
    String id;

    /**Версия*/
    @Version
    @Column(name = "VERSION")
    Long version = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        return id == null ? 0 : id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && id != null && obj instanceof BaseEntity && id.equals(((BaseEntity) obj).getId());
    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(this.getClass().getSimpleName()).append("{").append("id: ").append(id).append(", version: ")
                .append(version);

        Class<?> clazz = this.getClass();
        while (clazz != Object.class) {
            java.lang.reflect.Field[] fields = clazz.getDeclaredFields();
            for (java.lang.reflect.Field field : fields) {
                field.setAccessible(true);
                if ("serialVersionUID".equals(field.getName()))
                    continue;
                OneToOne oo = field.getAnnotation(OneToOne.class);
                OneToMany om = field.getAnnotation(OneToMany.class);
                ManyToMany mm = field.getAnnotation(ManyToMany.class);
                JoinTable jt = field.getAnnotation(JoinTable.class);
                if (oo != null) {
                    oo.mappedBy();
                    if (oo.mappedBy().length() > 0) continue;
                }
                if (om != null) {
                    om.mappedBy();
                    if (om.mappedBy().length() > 0) continue;
                }
                if (mm != null) {
                    mm.mappedBy();
                    if (mm.mappedBy().length() > 0) continue;
                }
                if (jt != null) {
                    jt.joinColumns();
                    if (jt.joinColumns().length > 0 && !jt.joinColumns()[0].updatable()) continue;
                }
                b.append(", ").append(field.getName()).append(": ");
                try {
                    if (field.getAnnotation(Transient.class) != null)
                        b.append("{TRANSIENT}");
                    else
                        b.append(field.get(this));
                } catch (Throwable e) {
                    b.append("*****");
                }
            }
            clazz = clazz.getSuperclass();
        }

        b.append("}");
        return b.toString();
    }
}
