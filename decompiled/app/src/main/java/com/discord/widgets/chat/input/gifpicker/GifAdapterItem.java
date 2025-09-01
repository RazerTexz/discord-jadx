package com.discord.widgets.chat.input.gifpicker;

import androidx.annotation.StringRes;
import b.d.b.a.outline;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.recycler.DiffKeyProvider;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GifAdapterItem.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\t\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0002\f\r¨\u0006\u000e"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem;", "Lcom/discord/utilities/recycler/DiffKeyProvider;", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$ViewType;", "type", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$ViewType;", "getType", "()Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$ViewType;", "<init>", "(Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$ViewType;)V", "GifItem", "SuggestedTermsItem", "ViewType", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class GifAdapterItem implements DiffKeyProvider {
    private final ViewType type;

    /* compiled from: GifAdapterItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0017\u0018B)\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\u00020\u00108\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u0082\u0001\u0002\u0019\u001a¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem;", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem;", "", "", "terms", "Ljava/util/List;", "getTerms", "()Ljava/util/List;", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$ViewType;", "viewType", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$ViewType;", "getViewType", "()Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$ViewType;", "getKey", "()Ljava/lang/String;", "key", "", "titleResId", "I", "getTitleResId", "()I", "<init>", "(Ljava/util/List;Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$ViewType;I)V", "SuggestedTermsEmptyResults", "SuggestedTermsNonEmptyResults", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults;", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem$SuggestedTermsNonEmptyResults;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static abstract class SuggestedTermsItem extends GifAdapterItem {
        private final List<String> terms;
        private final int titleResId;
        private final ViewType viewType;

        /* compiled from: GifAdapterItem.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\bJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\n\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults;", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem;", "", "", "component1", "()Ljava/util/List;", "", "component2", "()I", "terms", "titleResId", "copy", "(Ljava/util/List;I)Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getTitleResId", "Ljava/util/List;", "getTerms", "<init>", "(Ljava/util/List;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SuggestedTermsEmptyResults extends SuggestedTermsItem {
            private final List<String> terms;
            private final int titleResId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SuggestedTermsEmptyResults(List<String> list, int i) {
                super(list, ViewType.VIEW_TYPE_GIF_SEARCH_TERMS_EMPTY_RESULTS, i, null);
                Intrinsics3.checkNotNullParameter(list, "terms");
                this.terms = list;
                this.titleResId = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SuggestedTermsEmptyResults copy$default(SuggestedTermsEmptyResults suggestedTermsEmptyResults, List list, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    list = suggestedTermsEmptyResults.getTerms();
                }
                if ((i2 & 2) != 0) {
                    i = suggestedTermsEmptyResults.getTitleResId();
                }
                return suggestedTermsEmptyResults.copy(list, i);
            }

            public final List<String> component1() {
                return getTerms();
            }

            public final int component2() {
                return getTitleResId();
            }

            public final SuggestedTermsEmptyResults copy(List<String> terms, int titleResId) {
                Intrinsics3.checkNotNullParameter(terms, "terms");
                return new SuggestedTermsEmptyResults(terms, titleResId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SuggestedTermsEmptyResults)) {
                    return false;
                }
                SuggestedTermsEmptyResults suggestedTermsEmptyResults = (SuggestedTermsEmptyResults) other;
                return Intrinsics3.areEqual(getTerms(), suggestedTermsEmptyResults.getTerms()) && getTitleResId() == suggestedTermsEmptyResults.getTitleResId();
            }

            @Override // com.discord.widgets.chat.input.gifpicker.GifAdapterItem.SuggestedTermsItem
            public List<String> getTerms() {
                return this.terms;
            }

            @Override // com.discord.widgets.chat.input.gifpicker.GifAdapterItem.SuggestedTermsItem
            public int getTitleResId() {
                return this.titleResId;
            }

            public int hashCode() {
                List<String> terms = getTerms();
                return getTitleResId() + ((terms != null ? terms.hashCode() : 0) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("SuggestedTermsEmptyResults(terms=");
                sbU.append(getTerms());
                sbU.append(", titleResId=");
                sbU.append(getTitleResId());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* compiled from: GifAdapterItem.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\n\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\bJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005R\u001c\u0010\n\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem$SuggestedTermsNonEmptyResults;", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem;", "", "", "component1", "()Ljava/util/List;", "", "component2", "()I", "terms", "titleResId", "copy", "(Ljava/util/List;I)Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$SuggestedTermsItem$SuggestedTermsNonEmptyResults;", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getTerms", "I", "getTitleResId", "<init>", "(Ljava/util/List;I)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final /* data */ class SuggestedTermsNonEmptyResults extends SuggestedTermsItem {
            private final List<String> terms;
            private final int titleResId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SuggestedTermsNonEmptyResults(List<String> list, int i) {
                super(list, ViewType.VIEW_TYPE_GIF_SEARCH_TERMS_NON_EMPTY_RESULTS, i, null);
                Intrinsics3.checkNotNullParameter(list, "terms");
                this.terms = list;
                this.titleResId = i;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SuggestedTermsNonEmptyResults copy$default(SuggestedTermsNonEmptyResults suggestedTermsNonEmptyResults, List list, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    list = suggestedTermsNonEmptyResults.getTerms();
                }
                if ((i2 & 2) != 0) {
                    i = suggestedTermsNonEmptyResults.getTitleResId();
                }
                return suggestedTermsNonEmptyResults.copy(list, i);
            }

            public final List<String> component1() {
                return getTerms();
            }

            public final int component2() {
                return getTitleResId();
            }

            public final SuggestedTermsNonEmptyResults copy(List<String> terms, int titleResId) {
                Intrinsics3.checkNotNullParameter(terms, "terms");
                return new SuggestedTermsNonEmptyResults(terms, titleResId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SuggestedTermsNonEmptyResults)) {
                    return false;
                }
                SuggestedTermsNonEmptyResults suggestedTermsNonEmptyResults = (SuggestedTermsNonEmptyResults) other;
                return Intrinsics3.areEqual(getTerms(), suggestedTermsNonEmptyResults.getTerms()) && getTitleResId() == suggestedTermsNonEmptyResults.getTitleResId();
            }

            @Override // com.discord.widgets.chat.input.gifpicker.GifAdapterItem.SuggestedTermsItem
            public List<String> getTerms() {
                return this.terms;
            }

            @Override // com.discord.widgets.chat.input.gifpicker.GifAdapterItem.SuggestedTermsItem
            public int getTitleResId() {
                return this.titleResId;
            }

            public int hashCode() {
                List<String> terms = getTerms();
                return getTitleResId() + ((terms != null ? terms.hashCode() : 0) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("SuggestedTermsNonEmptyResults(terms=");
                sbU.append(getTerms());
                sbU.append(", titleResId=");
                sbU.append(getTitleResId());
                sbU.append(")");
                return sbU.toString();
            }
        }

        public /* synthetic */ SuggestedTermsItem(List list, ViewType viewType, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, viewType, i);
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return String.valueOf((_Collections.joinToString$default(getTerms(), null, null, null, 0, null, null, 63, null) + getTitleResId()).hashCode());
        }

        public List<String> getTerms() {
            return this.terms;
        }

        public int getTitleResId() {
            return this.titleResId;
        }

        public final ViewType getViewType() {
            return this.viewType;
        }

        private SuggestedTermsItem(List<String> list, ViewType viewType, @StringRes int i) {
            super(viewType, null);
            this.terms = list;
            this.viewType = viewType;
            this.titleResId = i;
        }
    }

    /* compiled from: GifAdapterItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$ViewType;", "", "<init>", "(Ljava/lang/String;I)V", "Companion", "VIEW_TYPE_GIF_ITEM", "VIEW_TYPE_GIF_SEARCH_TERMS_EMPTY_RESULTS", "VIEW_TYPE_GIF_SEARCH_TERMS_NON_EMPTY_RESULTS", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public enum ViewType {
        VIEW_TYPE_GIF_ITEM,
        VIEW_TYPE_GIF_SEARCH_TERMS_EMPTY_RESULTS,
        VIEW_TYPE_GIF_SEARCH_TERMS_NON_EMPTY_RESULTS;


        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final ViewType[] values = values();

        /* compiled from: GifAdapterItem.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$ViewType$Companion;", "", "", "index", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$ViewType;", "fromInt", "(I)Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$ViewType;", "", "values", "[Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$ViewType;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public final ViewType fromInt(int index) {
                return ViewType.access$getValues$cp()[index];
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public static final /* synthetic */ ViewType[] access$getValues$cp() {
            return values;
        }
    }

    private GifAdapterItem(ViewType viewType) {
        this.type = viewType;
    }

    public final ViewType getType() {
        return this.type;
    }

    /* compiled from: GifAdapterItem.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007R\u001c\u0010\u0019\u001a\u00020\u00058\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;", "Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem;", "Lcom/discord/models/gifpicker/dto/ModelGif;", "component1", "()Lcom/discord/models/gifpicker/dto/ModelGif;", "", "component2", "()Ljava/lang/String;", IconUtils.ANIMATED_IMAGE_EXTENSION, "query", "copy", "(Lcom/discord/models/gifpicker/dto/ModelGif;Ljava/lang/String;)Lcom/discord/widgets/chat/input/gifpicker/GifAdapterItem$GifItem;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/discord/models/gifpicker/dto/ModelGif;", "getGif", "Ljava/lang/String;", "getQuery", "key", "getKey", "<init>", "(Lcom/discord/models/gifpicker/dto/ModelGif;Ljava/lang/String;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class GifItem extends GifAdapterItem {
        private final ModelGif gif;
        private final String key;
        private final String query;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GifItem(ModelGif modelGif, String str) {
            super(ViewType.VIEW_TYPE_GIF_ITEM, null);
            Intrinsics3.checkNotNullParameter(modelGif, IconUtils.ANIMATED_IMAGE_EXTENSION);
            this.gif = modelGif;
            this.query = str;
            this.key = String.valueOf(hashCode());
        }

        public static /* synthetic */ GifItem copy$default(GifItem gifItem, ModelGif modelGif, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                modelGif = gifItem.gif;
            }
            if ((i & 2) != 0) {
                str = gifItem.query;
            }
            return gifItem.copy(modelGif, str);
        }

        /* renamed from: component1, reason: from getter */
        public final ModelGif getGif() {
            return this.gif;
        }

        /* renamed from: component2, reason: from getter */
        public final String getQuery() {
            return this.query;
        }

        public final GifItem copy(ModelGif gif, String query) {
            Intrinsics3.checkNotNullParameter(gif, IconUtils.ANIMATED_IMAGE_EXTENSION);
            return new GifItem(gif, query);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GifItem)) {
                return false;
            }
            GifItem gifItem = (GifItem) other;
            return Intrinsics3.areEqual(this.gif, gifItem.gif) && Intrinsics3.areEqual(this.query, gifItem.query);
        }

        public final ModelGif getGif() {
            return this.gif;
        }

        @Override // com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final String getQuery() {
            return this.query;
        }

        public int hashCode() {
            ModelGif modelGif = this.gif;
            int iHashCode = (modelGif != null ? modelGif.hashCode() : 0) * 31;
            String str = this.query;
            return iHashCode + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("GifItem(gif=");
            sbU.append(this.gif);
            sbU.append(", query=");
            return outline.J(sbU, this.query, ")");
        }

        public /* synthetic */ GifItem(ModelGif modelGif, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(modelGif, (i & 2) != 0 ? "" : str);
        }
    }

    public /* synthetic */ GifAdapterItem(ViewType viewType, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewType);
    }
}
