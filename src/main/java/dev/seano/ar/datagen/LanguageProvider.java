/*
 * Licensed under the CC0 1.0 Universal (CC0 1.0) Public Domain Dedication.
 * https://creativecommons.org/publicdomain/zero/1.0/
 */

package dev.seano.ar.datagen;

import dev.seano.ar.block.ARBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

/**
 * @author Sean O'Connor
 */
public class LanguageProvider extends FabricLanguageProvider {

    protected LanguageProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.add(ARBlocks.ROSE, "Rose");
        translationBuilder.add(ARBlocks.POTTED_ROSE, "Potted Rose");
    }
}
