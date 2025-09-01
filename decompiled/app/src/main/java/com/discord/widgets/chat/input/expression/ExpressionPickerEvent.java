package com.discord.widgets.chat.input.expression;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ExpressionPickerEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent;", "", "<init>", "()V", "CloseExpressionPicker", "OpenStickerPicker", "Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent$CloseExpressionPicker;", "Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent$OpenStickerPicker;", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public abstract class ExpressionPickerEvent {

    /* compiled from: ExpressionPickerEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent$CloseExpressionPicker;", "Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent;", "<init>", "()V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final class CloseExpressionPicker extends ExpressionPickerEvent {
        public static final CloseExpressionPicker INSTANCE = new CloseExpressionPicker();

        private CloseExpressionPicker() {
            super(null);
        }
    }

    /* compiled from: ExpressionPickerEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0004\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000e\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0011\u0010\bJ\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b\u001a\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u000bR!\u0010\f\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b\u001e\u0010\u0005¨\u0006!"}, d2 = {"Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent$OpenStickerPicker;", "Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent;", "", "Lcom/discord/primitives/StickerPackId;", "component1", "()Ljava/lang/Long;", "", "component2", "()Ljava/lang/String;", "", "component3", "()Z", "stickerPackId", "searchText", "inline", "copy", "(Ljava/lang/Long;Ljava/lang/String;Z)Lcom/discord/widgets/chat/input/expression/ExpressionPickerEvent$OpenStickerPicker;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getSearchText", "Z", "getInline", "Ljava/lang/Long;", "getStickerPackId", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Z)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class OpenStickerPicker extends ExpressionPickerEvent {
        private final boolean inline;
        private final String searchText;
        private final Long stickerPackId;

        public OpenStickerPicker() {
            this(null, null, false, 7, null);
        }

        public /* synthetic */ OpenStickerPicker(Long l, String str, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z2);
        }

        public static /* synthetic */ OpenStickerPicker copy$default(OpenStickerPicker openStickerPicker, Long l, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                l = openStickerPicker.stickerPackId;
            }
            if ((i & 2) != 0) {
                str = openStickerPicker.searchText;
            }
            if ((i & 4) != 0) {
                z2 = openStickerPicker.inline;
            }
            return openStickerPicker.copy(l, str, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final Long getStickerPackId() {
            return this.stickerPackId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getSearchText() {
            return this.searchText;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getInline() {
            return this.inline;
        }

        public final OpenStickerPicker copy(Long stickerPackId, String searchText, boolean inline) {
            return new OpenStickerPicker(stickerPackId, searchText, inline);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OpenStickerPicker)) {
                return false;
            }
            OpenStickerPicker openStickerPicker = (OpenStickerPicker) other;
            return Intrinsics3.areEqual(this.stickerPackId, openStickerPicker.stickerPackId) && Intrinsics3.areEqual(this.searchText, openStickerPicker.searchText) && this.inline == openStickerPicker.inline;
        }

        public final boolean getInline() {
            return this.inline;
        }

        public final String getSearchText() {
            return this.searchText;
        }

        public final Long getStickerPackId() {
            return this.stickerPackId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Long l = this.stickerPackId;
            int iHashCode = (l != null ? l.hashCode() : 0) * 31;
            String str = this.searchText;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.inline;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode2 + i;
        }

        public String toString() {
            StringBuilder sbU = outline.U("OpenStickerPicker(stickerPackId=");
            sbU.append(this.stickerPackId);
            sbU.append(", searchText=");
            sbU.append(this.searchText);
            sbU.append(", inline=");
            return outline.O(sbU, this.inline, ")");
        }

        public OpenStickerPicker(Long l, String str, boolean z2) {
            super(null);
            this.stickerPackId = l;
            this.searchText = str;
            this.inline = z2;
        }
    }

    private ExpressionPickerEvent() {
    }

    public /* synthetic */ ExpressionPickerEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
