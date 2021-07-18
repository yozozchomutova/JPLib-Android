package net.jozoproductions.jplibandroid.spaces.particlesystem2d;

import net.jozoproductions.jplibandroid.math.Mathf;
import net.jozoproductions.jplibandroid.math.Vector2;

public class ParticleUtils2D {

    public static void RandomizeVelocity(ParticlePack2D particlePack2D, int minVelocity, int maxVelocity) {
        for (int i = 0; i < particlePack2D.particles.size(); i++) {
            particlePack2D.particles.get(i).velocity = new Vector2(
                    Mathf.getRandomFloat(minVelocity, maxVelocity), Mathf.getRandomFloat(minVelocity, maxVelocity));
        }
    }
}
