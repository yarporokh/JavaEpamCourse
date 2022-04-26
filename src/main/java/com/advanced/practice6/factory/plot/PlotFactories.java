package com.advanced.practice6.factory.plot;

import java.util.StringJoiner;

public class PlotFactories {

    public PlotFactory classicDisneyPlotFactory(Character hero, Character beloved, Character villain) {
        String plot = String.format("%s is great. %s and %s love each other. " +
                "%s interferes with their happiness but loses in the end.", hero.name(), hero.name(), beloved.name(), villain.name());

        return new PlotFactory() {
            @Override
            public Plot plot() {
                return new Plot() {
                    @Override
                    public String toString() {
                        return plot;
                    }
                };
            }
        };
    }

    public PlotFactory contemporaryDisneyPlotFactory(Character hero, EpicCrisis epicCrisis, Character funnyFriend) {
        String plot = String.format("%s feels a bit awkward and uncomfortable. " +
                "But personal issues fades, when a big trouble comes - %s. " +
                "%s stands up against it, but with no success at first." +
                "But putting self together and help of friends, " +
                "including spectacular funny %s restore the spirit and %s " +
                "overcomes the crisis and gains gratitude and respect", hero.name(), epicCrisis.name(), hero.name(), funnyFriend.name(), hero.name());

        return new PlotFactory() {
            @Override
            public Plot plot() {
                return new Plot() {
                    @Override
                    public String toString() {
                        return plot;
                    }
                };
            }
        };
    }

    public PlotFactory marvelPlotFactory(Character[] heroes, EpicCrisis epicCrisis, Character villain) {

        StringJoiner joiner = new StringJoiner(", brave ");
        for (Character hero : heroes)
            joiner.add(hero.name());
        String braveHeroes = "brave " + joiner.toString();

        String plot = String.format("%s threatens the world. " +
                "But %s on guard. " +
                "So, no way that intrigues of %s overcome the willpower of inflexible heroes", epicCrisis.name(), braveHeroes, villain.name());

        return new PlotFactory() {
            @Override
            public Plot plot() {
                return new Plot() {
                    @Override
                    public String toString() {
                        return plot;
                    }
                };
            }
        };
    }
}
