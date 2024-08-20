// package OutsideEntities.Factories;

// import OutsideEntities.Monsters.Bat;
// import OutsideEntities.Monsters.Boss;
// import OutsideEntities.Monsters.Cursed_Tree;
// import OutsideEntities.Monsters.Goblin;
// import OutsideEntities.Monsters.Goblin0;
// import OutsideEntities.Monsters.Monster;

// public class MonsterFactory {

//     public Monster createMonster(String type) {
//         switch (type.toLowerCase()) {
//             case "bat":
//                 return new Bat();
//             case "boss":
//                 return new Boss("Generic Boss", 100, 10, 1.0, 1.0, false, 100);
//             case "cursed_tree":
//                 return new Cursed_Tree();
//             case "goblin":
//                 return new Goblin();
//             case "goblin0":
//                 return new Goblin0();
//             default:
//                 throw new IllegalArgumentException("Unknown monster type: " + type);
//         }
//     }
// }
