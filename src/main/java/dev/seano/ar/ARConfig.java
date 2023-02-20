/*
 * Licensed under the CC0 1.0 Universal (CC0 1.0) Public Domain Dedication.
 * https://creativecommons.org/publicdomain/zero/1.0/
 */

/*
 * Licensed under the CC0 1.0 Universal (CC0 1.0) Public Domain Dedication.
 * https://creativecommons.org/publicdomain/zero/1.0/
 */

package dev.seano.ar;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

/**
 * @author Sean O'Connor
 */
@Config(name = ARMod.MOD_ID)
public class ARConfig implements ConfigData {
    @Comment("The chance for a Sniffer to sniff up a rose (0.1 = 10%, 0.2 = 20%, etc.)")
    public double roseChance = 0.1;
}
