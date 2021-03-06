package viceCity.models.guns;

import viceCity.models.players.BasePlayer;

import static viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int totalBullets;
    private boolean canFire;
    protected BaseGun(String name, int bulletsPerBarrel, int totalBullets){
        setName(name);
        setBulletsPerBarrel(bulletsPerBarrel);
        setTotalBullets(totalBullets);
        canFire = canFire();
    }

    protected void setTotalBullets(int totalBullets) {
        if (totalBullets < 0){
            throw new IllegalArgumentException(TOTAL_BULLETS_LESS_THAN_ZERO);
        }
        this.totalBullets = totalBullets;
    }

    protected void setBulletsPerBarrel(int bulletsPerBarrel) {
        if (bulletsPerBarrel < 0){
            throw new IllegalArgumentException(BULLETS_LESS_THAN_ZERO);
        }
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(NAME_NULL);
        }
        this.name = name;
    }

    //TODO double check for below zero
    protected void reload(int bulletCapacity){
        setBulletsPerBarrel(bulletCapacity);
        this.totalBullets -= bulletCapacity;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return this.bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return totalBullets > 0;
    }

    @Override
    public int getTotalBullets() {
        return this.totalBullets;
    }


}
