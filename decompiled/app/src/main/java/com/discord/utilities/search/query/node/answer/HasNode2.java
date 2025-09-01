package com.discord.utilities.search.query.node.answer;

import b.d.b.a.outline;
import com.discord.utilities.search.strings.SearchStringProvider;
import com.discord.widgets.chat.AutocompleteUtils;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.MediaStreamTrack;

/* compiled from: HasNode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;", "", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "searchStringProvider", "", "getLocalizedInputText", "(Lcom/discord/utilities/search/strings/SearchStringProvider;)Ljava/lang/String;", "restParamValue", "Ljava/lang/String;", "getRestParamValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "LINK", "EMBED", "FILE", "VIDEO", "IMAGE", "SOUND", AutocompleteUtils.STICKER, "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.discord.utilities.search.query.node.answer.HasAnswerOption, reason: use source file name */
/* loaded from: classes2.dex */
public enum HasNode2 {
    LINK("link"),
    EMBED("embed"),
    FILE("file"),
    VIDEO(MediaStreamTrack.VIDEO_TRACK_KIND),
    IMAGE("image"),
    SOUND("sound"),
    STICKER("sticker");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String restParamValue;

    /* compiled from: HasNode.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/discord/utilities/search/query/node/answer/HasAnswerOption$Companion;", "", "", "match", "Lcom/discord/utilities/search/strings/SearchStringProvider;", "searchStringProvider", "Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;", "getOptionFromString", "(Ljava/lang/String;Lcom/discord/utilities/search/strings/SearchStringProvider;)Lcom/discord/utilities/search/query/node/answer/HasAnswerOption;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.query.node.answer.HasAnswerOption$Companion, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final HasNode2 getOptionFromString(String match, SearchStringProvider searchStringProvider) {
            Intrinsics3.checkNotNullParameter(match, "match");
            Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
            if (Intrinsics3.areEqual(match, searchStringProvider.getLinkAnswerString())) {
                return HasNode2.LINK;
            }
            if (Intrinsics3.areEqual(match, searchStringProvider.getEmbedAnswerString())) {
                return HasNode2.EMBED;
            }
            if (Intrinsics3.areEqual(match, searchStringProvider.getFileAnswerString())) {
                return HasNode2.FILE;
            }
            if (Intrinsics3.areEqual(match, searchStringProvider.getVideoAnswerString())) {
                return HasNode2.VIDEO;
            }
            if (Intrinsics3.areEqual(match, searchStringProvider.getImageAnswerString())) {
                return HasNode2.IMAGE;
            }
            if (Intrinsics3.areEqual(match, searchStringProvider.getSoundAnswerString())) {
                return HasNode2.SOUND;
            }
            if (Intrinsics3.areEqual(match, searchStringProvider.getStickerAnswerString())) {
                return HasNode2.STICKER;
            }
            throw new IllegalArgumentException(outline.w("invalid match: ", match));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.search.query.node.answer.HasAnswerOption$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            HasNode2.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            iArr[HasNode2.LINK.ordinal()] = 1;
            iArr[HasNode2.EMBED.ordinal()] = 2;
            iArr[HasNode2.FILE.ordinal()] = 3;
            iArr[HasNode2.VIDEO.ordinal()] = 4;
            iArr[HasNode2.IMAGE.ordinal()] = 5;
            iArr[HasNode2.SOUND.ordinal()] = 6;
            iArr[HasNode2.STICKER.ordinal()] = 7;
        }
    }

    HasNode2(String str) {
        this.restParamValue = str;
    }

    public final String getLocalizedInputText(SearchStringProvider searchStringProvider) {
        Intrinsics3.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        switch (this) {
            case LINK:
                return searchStringProvider.getLinkAnswerString();
            case EMBED:
                return searchStringProvider.getEmbedAnswerString();
            case FILE:
                return searchStringProvider.getFileAnswerString();
            case VIDEO:
                return searchStringProvider.getVideoAnswerString();
            case IMAGE:
                return searchStringProvider.getImageAnswerString();
            case SOUND:
                return searchStringProvider.getSoundAnswerString();
            case STICKER:
                return searchStringProvider.getStickerAnswerString();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String getRestParamValue() {
        return this.restParamValue;
    }
}
