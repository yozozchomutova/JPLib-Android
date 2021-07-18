package net.jozoproductions.jplibandroid.spaces.particlesystem2d;

import java.util.ArrayList;

public class ParticlePack2D {

    private OnParticlePackDie onParticlePackDie;

    public ArrayList<Particle2D> particles = new ArrayList<>();

    public int lifeTime;

    public ParticlePack2D(ArrayList<Particle2D> particles, int lifeTime, OnParticlePackDie onParticlePackDie) {
        this.particles = particles;
        this.lifeTime = lifeTime;
        this.onParticlePackDie = onParticlePackDie;
    }

    public void Update() {
        lifeTime--;

        if (lifeTime == 0)
            RemoveAll();

        for (int i = 0; i < particles.size(); i++) {
            particles.get(i).Update();
        }
    }

    public void RemoveAll() {
        for (int i = particles.size()-1; i >= 0; i--) {
            particles.remove(i);
        }

        onParticlePackDie.OnParticlePackDie();
    }
}
