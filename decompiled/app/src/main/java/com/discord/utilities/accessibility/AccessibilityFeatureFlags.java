package com.discord.utilities.accessibility;

import com.discord.api.permission.Permission;
import kotlin.Metadata;

/* compiled from: AccessibilityFeatureFlags.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\t\n\u0002\b\u001c\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/discord/utilities/accessibility/AccessibilityFeatureFlags;", "", "", "value", "J", "getValue", "()J", "<init>", "(Ljava/lang/String;IJ)V", "NONE", "SCREENREADER", "REDUCED_MOTION", "REDUCED_TRANSPARENCY", "HIGH_CONTRAST", "BOLD_TEXT", "GRAYSCALE", "INVERT_COLORS", "PREFERS_COLOR_SCHEME_LIGHT", "PREFERS_COLOR_SCHEME_DARK", "CHAT_FONT_SCALE_INCREASED", "CHAT_FONT_SCALE_DECREASED", "ZOOM_LEVEL_INCREASED", "ZOOM_LEVEL_DECREASED", "MESSAGE_GROUP_SPACING_INCREASED", "MESSAGE_GROUP_SPACING_DECREASED", "DARK_SIDEBAR", "REDUCED_MOTION_FROM_USER_SETTINGS", "SATURATION_LEVEL_DECREASED", "FORCED_COLORS", "FORCED_COLORS_FROM_USER_SETTINGS", "utils_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public enum AccessibilityFeatureFlags {
    NONE(0),
    SCREENREADER(1),
    REDUCED_MOTION(2),
    REDUCED_TRANSPARENCY(4),
    HIGH_CONTRAST(8),
    BOLD_TEXT(16),
    GRAYSCALE(32),
    INVERT_COLORS(64),
    PREFERS_COLOR_SCHEME_LIGHT(128),
    PREFERS_COLOR_SCHEME_DARK(256),
    CHAT_FONT_SCALE_INCREASED(512),
    CHAT_FONT_SCALE_DECREASED(Permission.VIEW_CHANNEL),
    ZOOM_LEVEL_INCREASED(Permission.SEND_MESSAGES),
    ZOOM_LEVEL_DECREASED(Permission.SEND_TTS_MESSAGES),
    MESSAGE_GROUP_SPACING_INCREASED(Permission.MANAGE_MESSAGES),
    MESSAGE_GROUP_SPACING_DECREASED(Permission.EMBED_LINKS),
    DARK_SIDEBAR(Permission.ATTACH_FILES),
    REDUCED_MOTION_FROM_USER_SETTINGS(Permission.READ_MESSAGE_HISTORY),
    SATURATION_LEVEL_DECREASED(Permission.MENTION_EVERYONE),
    FORCED_COLORS(Permission.USE_EXTERNAL_EMOJIS),
    FORCED_COLORS_FROM_USER_SETTINGS(Permission.VIEW_GUILD_ANALYTICS);

    private final long value;

    AccessibilityFeatureFlags(long j) {
        this.value = j;
    }

    public final long getValue() {
        return this.value;
    }
}
