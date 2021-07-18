package net.jozoproductions.jplibandroid.spaces.particlesystem2d;

import android.graphics.Bitmap;

import net.jozoproductions.jplibandroid.math.Vector2;

import java.util.ArrayList;

public class ParticleSystem2D {

    public ArrayList<ParticlePack2D> particlePacks = new ArrayList<>();

    public void CreateParticlePack(Bitmap texture, int particleCount, int x, int y, int lifetime) {
        ArrayList<Particle2D> particleList = new ArrayList<>();

        for (int i = 0; i < particleCount; i++) {
            particleList.add(new Particle2D(new Vector2(x, y), texture));
        }

        ParticlePack2D particleSystem2D = new ParticlePack2D(particleList, lifetime, new OnParticlePackDie() {
            @Override
            public void OnParticlePackDie() {
                particlePacks.remove(this);
            }
        });

        particlePacks.add(particleSystem2D);
    }

    public void AddParticlePack(ParticlePack2D particlePack) {
        particlePacks.add(particlePack);
    }

    public void Update() {
        for (int i = 0; i < particlePacks.size(); i++) {
            particlePacks.get(i).Update();
        }
    }
}
