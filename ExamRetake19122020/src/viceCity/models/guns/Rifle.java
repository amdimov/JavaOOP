package viceCity.models.guns;

public class Rifle extends BaseGun {
    public Rifle(String name) {
        super(name, 50, 500);
    }

    @Override
    public int fire() {
        final int FIRE_CAPACITY = 5;
        int shootBullets = super.getTotalBullets();
//        while (canFire()) {
//            if (super.getBulletsPerBarrel() == 0){
//                super.reload(super.getBulletsPerBarrel());
//            }
//            super.setBulletsPerBarrel(super.getBulletsPerBarrel() - FIRE_CAPACITY);
//            shootBullets += FIRE_CAPACITY;
//        }
        super.setTotalBullets(0);
        return shootBullets;
    }
}
