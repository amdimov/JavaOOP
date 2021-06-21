package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static int BULLETS_PER_BARREL = 10;
    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, 100);
    }

    @Override
    public int fire() {
//        final int FIRE_CAPACITY = 1;
        int shootBullets = super.getTotalBullets();
//        while (canFire()) {
//            if (super.getBulletsPerBarrel() == 0){
//                super.reload(BULLETS_PER_BARREL);
//            }
//            super.setBulletsPerBarrel(super.getBulletsPerBarrel() - FIRE_CAPACITY);
//            shootBullets += FIRE_CAPACITY;
//        }
       //return shootBullets;
        super.setTotalBullets(0);
        return shootBullets;
    }
}
