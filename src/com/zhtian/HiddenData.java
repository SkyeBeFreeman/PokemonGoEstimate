package com.zhtian;

public class HiddenData {

	public int num;
	public int hp;
	public int attack;
	public int defense;
	public int spAttack;
	public int spDefense;
	public int speed;
	
	public HiddenData(int q, int w, int e, int r, int t, int y, int u) {
		num = q;
		hp = w;
		attack = e;
		defense = r;
		spAttack = t;
		spDefense = y;
		speed = u;
	}
	
}

class Star_Cp {
	
	public int stardust;
	public double cp_multiplier1;
	public double cp_multiplier2;
	public double cp_multiplier3;
	public double cp_multiplier4;
	
	public Star_Cp (int stardust, double q, double w, double e, double r) {
		this.stardust = stardust;
		cp_multiplier1 = q;
		cp_multiplier2 = w;
		cp_multiplier3 = e;
		cp_multiplier4 = r;
	}
	
}
