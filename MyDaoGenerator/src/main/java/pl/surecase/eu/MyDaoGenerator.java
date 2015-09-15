package pl.surecase.eu;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class MyDaoGenerator {

    public static void main(String args[]) throws Exception {
        Schema schema = new Schema(1, "com.kukuhyoniatmoko.smguide.persistence.db");
        schema.setDefaultJavaPackageDao("com.kukuhyoniatmoko.smguide.persistence.dao");
        schema.enableKeepSectionsByDefault();

        Entity monster = schema.addEntity("Monster");
        monster.addIdProperty();
        monster.addStringProperty("name");
        monster.addStringProperty("type");
        monster.addStringProperty("star");
        monster.addStringProperty("awakenedName");
        monster.addStringProperty("imageUrl");

        Entity type = schema.addEntity("Type");
        type.addIdProperty();
        type.addStringProperty("name");

        Entity property = schema.addEntity("Property");
        type.addIdProperty();
        property.addStringProperty("name");

        Entity monsterType = schema.addEntity("MonsterType");
        monsterType.addIdProperty();

        monster.addToOne(monsterType, monster.addLongProperty("monsterTypeId").getProperty());
        monsterType.addToOne(type, monsterType.addLongProperty("typeId").getProperty());

        new DaoGenerator().generateAll(schema, args[0]);
    }
}
