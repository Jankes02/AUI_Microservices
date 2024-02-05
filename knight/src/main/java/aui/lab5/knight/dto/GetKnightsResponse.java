package aui.lab5.knight.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

/**
 * GET knights response. Contains list of available knights. Can be used to list particular user's knights as
 * well as all knights in the game.
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
public class GetKnightsResponse {

    /**
     * Represents single knight in list.
     */
    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @ToString
    @EqualsAndHashCode
    public static class Knight {
        /**
         * Unique id identifying knight.
         */
        private UUID id;

        /**
         * Name of the knight.
         */
        private String name;
    }

    /**
     * Name of the selected knights.
     */
    @Singular
    private List<Knight> knights;
}