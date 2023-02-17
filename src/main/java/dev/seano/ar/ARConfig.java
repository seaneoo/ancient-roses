/*
 * Licensed under the CC0 1.0 Universal (CC0 1.0) Public Domain Dedication.
 * https://creativecommons.org/publicdomain/zero/1.0/
 */

package dev.seano.ar;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

/**
 * @author Sean O'Connor
 */
@Config(name = ARMod.MOD_ID)
public class ARConfig implements ConfigData {
    public double roseChance = 0.1;
}
