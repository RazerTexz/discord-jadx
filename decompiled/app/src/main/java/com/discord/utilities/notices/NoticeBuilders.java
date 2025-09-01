package com.discord.utilities.notices;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppLog;
import com.discord.i18n.RenderContext;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnections;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NoticeBuilders.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\t\u0010\bJ%\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eR6\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00110\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/discord/utilities/notices/NoticeBuilders;", "", "Landroid/content/Context;", "context", "Lcom/discord/stores/StoreNotices$Dialog;", "notice", "Lcom/discord/utilities/notices/NoticeBuilders$DialogData;", "requestRatingModalBuilder", "(Landroid/content/Context;Lcom/discord/stores/StoreNotices$Dialog;)Lcom/discord/utilities/notices/NoticeBuilders$DialogData;", "deleteConnectionModalBuilder", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "showNotice", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Lcom/discord/stores/StoreNotices$Dialog;)V", "", "Lcom/discord/stores/StoreNotices$Dialog$Type;", "Lkotlin/Function2;", "noticeDataBuilders", "Ljava/util/Map;", "<init>", "()V", "DialogData", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class NoticeBuilders {
    public static final NoticeBuilders INSTANCE;
    private static final Map<StoreNotices.Dialog.Type, Function2<Context, StoreNotices.Dialog, DialogData>> noticeDataBuilders;

    /* compiled from: NoticeBuilders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0082\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\"\b\u0002\u0010\u0015\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0018\u00010\b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b+\u0010,J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J*\u0010\r\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010Jl\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\"\b\u0002\u0010\u0015\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0018\u00010\b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b#\u0010\u0010R\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010\u0004R\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b&\u0010\u0004R\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010$\u001a\u0004\b'\u0010\u0004R3\u0010\u0015\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b)\u0010\u000eR\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b*\u0010\u0004¨\u0006-"}, d2 = {"Lcom/discord/utilities/notices/NoticeBuilders$DialogData;", "", "", "component1", "()Ljava/lang/CharSequence;", "component2", "component3", "component4", "", "", "Lkotlin/Function1;", "Landroid/view/View;", "", "component5", "()Ljava/util/Map;", "component6", "()Ljava/lang/Integer;", "headerText", "bodyText", "okText", "cancelText", "listenerMap", "extraLayoutId", "copy", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/util/Map;Ljava/lang/Integer;)Lcom/discord/utilities/notices/NoticeBuilders$DialogData;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getExtraLayoutId", "Ljava/lang/CharSequence;", "getOkText", "getHeaderText", "getCancelText", "Ljava/util/Map;", "getListenerMap", "getBodyText", "<init>", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/util/Map;Ljava/lang/Integer;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
    public static final /* data */ class DialogData {
        private final CharSequence bodyText;
        private final CharSequence cancelText;
        private final Integer extraLayoutId;
        private final CharSequence headerText;
        private final Map<Integer, Function1<View, Unit>> listenerMap;
        private final CharSequence okText;

        /* JADX WARN: Multi-variable type inference failed */
        public DialogData(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map<Integer, ? extends Function1<? super View, Unit>> map, Integer num) {
            Intrinsics3.checkNotNullParameter(charSequence, "headerText");
            Intrinsics3.checkNotNullParameter(charSequence2, "bodyText");
            this.headerText = charSequence;
            this.bodyText = charSequence2;
            this.okText = charSequence3;
            this.cancelText = charSequence4;
            this.listenerMap = map;
            this.extraLayoutId = num;
        }

        public static /* synthetic */ DialogData copy$default(DialogData dialogData, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map map, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                charSequence = dialogData.headerText;
            }
            if ((i & 2) != 0) {
                charSequence2 = dialogData.bodyText;
            }
            CharSequence charSequence5 = charSequence2;
            if ((i & 4) != 0) {
                charSequence3 = dialogData.okText;
            }
            CharSequence charSequence6 = charSequence3;
            if ((i & 8) != 0) {
                charSequence4 = dialogData.cancelText;
            }
            CharSequence charSequence7 = charSequence4;
            if ((i & 16) != 0) {
                map = dialogData.listenerMap;
            }
            Map map2 = map;
            if ((i & 32) != 0) {
                num = dialogData.extraLayoutId;
            }
            return dialogData.copy(charSequence, charSequence5, charSequence6, charSequence7, map2, num);
        }

        /* renamed from: component1, reason: from getter */
        public final CharSequence getHeaderText() {
            return this.headerText;
        }

        /* renamed from: component2, reason: from getter */
        public final CharSequence getBodyText() {
            return this.bodyText;
        }

        /* renamed from: component3, reason: from getter */
        public final CharSequence getOkText() {
            return this.okText;
        }

        /* renamed from: component4, reason: from getter */
        public final CharSequence getCancelText() {
            return this.cancelText;
        }

        public final Map<Integer, Function1<View, Unit>> component5() {
            return this.listenerMap;
        }

        /* renamed from: component6, reason: from getter */
        public final Integer getExtraLayoutId() {
            return this.extraLayoutId;
        }

        public final DialogData copy(CharSequence headerText, CharSequence bodyText, CharSequence okText, CharSequence cancelText, Map<Integer, ? extends Function1<? super View, Unit>> listenerMap, Integer extraLayoutId) {
            Intrinsics3.checkNotNullParameter(headerText, "headerText");
            Intrinsics3.checkNotNullParameter(bodyText, "bodyText");
            return new DialogData(headerText, bodyText, okText, cancelText, listenerMap, extraLayoutId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DialogData)) {
                return false;
            }
            DialogData dialogData = (DialogData) other;
            return Intrinsics3.areEqual(this.headerText, dialogData.headerText) && Intrinsics3.areEqual(this.bodyText, dialogData.bodyText) && Intrinsics3.areEqual(this.okText, dialogData.okText) && Intrinsics3.areEqual(this.cancelText, dialogData.cancelText) && Intrinsics3.areEqual(this.listenerMap, dialogData.listenerMap) && Intrinsics3.areEqual(this.extraLayoutId, dialogData.extraLayoutId);
        }

        public final CharSequence getBodyText() {
            return this.bodyText;
        }

        public final CharSequence getCancelText() {
            return this.cancelText;
        }

        public final Integer getExtraLayoutId() {
            return this.extraLayoutId;
        }

        public final CharSequence getHeaderText() {
            return this.headerText;
        }

        public final Map<Integer, Function1<View, Unit>> getListenerMap() {
            return this.listenerMap;
        }

        public final CharSequence getOkText() {
            return this.okText;
        }

        public int hashCode() {
            CharSequence charSequence = this.headerText;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            CharSequence charSequence2 = this.bodyText;
            int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
            CharSequence charSequence3 = this.okText;
            int iHashCode3 = (iHashCode2 + (charSequence3 != null ? charSequence3.hashCode() : 0)) * 31;
            CharSequence charSequence4 = this.cancelText;
            int iHashCode4 = (iHashCode3 + (charSequence4 != null ? charSequence4.hashCode() : 0)) * 31;
            Map<Integer, Function1<View, Unit>> map = this.listenerMap;
            int iHashCode5 = (iHashCode4 + (map != null ? map.hashCode() : 0)) * 31;
            Integer num = this.extraLayoutId;
            return iHashCode5 + (num != null ? num.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("DialogData(headerText=");
            sbU.append(this.headerText);
            sbU.append(", bodyText=");
            sbU.append(this.bodyText);
            sbU.append(", okText=");
            sbU.append(this.okText);
            sbU.append(", cancelText=");
            sbU.append(this.cancelText);
            sbU.append(", listenerMap=");
            sbU.append(this.listenerMap);
            sbU.append(", extraLayoutId=");
            return outline.F(sbU, this.extraLayoutId, ")");
        }

        public /* synthetic */ DialogData(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map map, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(charSequence, charSequence2, (i & 4) != 0 ? null : charSequence3, (i & 8) != 0 ? null : charSequence4, (i & 16) != 0 ? null : map, (i & 32) != 0 ? null : num);
        }
    }

    /* compiled from: NoticeBuilders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/discord/i18n/RenderContext;", "", "invoke", "(Lcom/discord/i18n/RenderContext;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.notices.NoticeBuilders$deleteConnectionModalBuilder$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.uppercase = true;
        }
    }

    /* compiled from: NoticeBuilders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "it", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.notices.NoticeBuilders$deleteConnectionModalBuilder$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ StoreNotices.Dialog $notice;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(StoreNotices.Dialog dialog) {
            super(1);
            this.$notice = dialog;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            if (this.$notice.getMetadata() != null) {
                Object obj = this.$notice.getMetadata().get(WidgetSettingsUserConnections.PLATFORM_NAME);
                if (!(obj instanceof String)) {
                    obj = null;
                }
                String str = (String) obj;
                Object obj2 = this.$notice.getMetadata().get(WidgetSettingsUserConnections.CONNECTION_ID);
                String str2 = (String) (obj2 instanceof String ? obj2 : null);
                if (str == null || str2 == null) {
                    Logger.e$default(AppLog.g, "Delete Connections", new Exception(outline.y(str, ", ", str2)), null, 4, null);
                } else {
                    StoreStream.INSTANCE.getUserConnections().deleteUserConnection(str, str2);
                }
            }
        }
    }

    /* compiled from: NoticeBuilders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "<anonymous parameter 0>", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.notices.NoticeBuilders$requestRatingModalBuilder$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            StoreStream.INSTANCE.getReviewRequest().onReviewRequestShown();
        }
    }

    /* compiled from: NoticeBuilders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "view", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.notices.NoticeBuilders$requestRatingModalBuilder$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            StoreStream.INSTANCE.getReviewRequest().onUserAcceptedRequest();
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "view.context");
            UriHandler.directToPlayStore$default(context, null, null, 6, null);
        }
    }

    /* compiled from: NoticeBuilders.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "<anonymous parameter 0>", "", "invoke", "(Landroid/view/View;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.utilities.notices.NoticeBuilders$requestRatingModalBuilder$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "<anonymous parameter 0>");
            StoreStream.INSTANCE.getReviewRequest().onUserDismissedRequest();
        }
    }

    static {
        NoticeBuilders noticeBuilders = new NoticeBuilders();
        INSTANCE = noticeBuilders;
        noticeDataBuilders = Maps6.mapOf(Tuples.to(StoreNotices.Dialog.Type.REQUEST_RATING_MODAL, new NoticeBuilders2(noticeBuilders)), Tuples.to(StoreNotices.Dialog.Type.DELETE_CONNECTION_MODAL, new NoticeBuilders3(noticeBuilders)));
    }

    private NoticeBuilders() {
    }

    public static final /* synthetic */ DialogData access$deleteConnectionModalBuilder(NoticeBuilders noticeBuilders, Context context, StoreNotices.Dialog dialog) {
        return noticeBuilders.deleteConnectionModalBuilder(context, dialog);
    }

    public static final /* synthetic */ DialogData access$requestRatingModalBuilder(NoticeBuilders noticeBuilders, Context context, StoreNotices.Dialog dialog) {
        return noticeBuilders.requestRatingModalBuilder(context, dialog);
    }

    @SuppressLint({"DefaultLocale"})
    private final DialogData deleteConnectionModalBuilder(Context context, StoreNotices.Dialog notice) {
        Object[] objArr = new Object[1];
        Map<String, Object> metadata = notice.getMetadata();
        objArr[0] = metadata != null ? metadata.get(WidgetSettingsUserConnections.PLATFORM_TITLE) : null;
        return new DialogData(FormatUtils.b(context, R.string.disconnect_account_title, objArr, AnonymousClass1.INSTANCE), FormatUtils.h(context, R.string.disconnect_account_body, new Object[0], null, 4), FormatUtils.h(context, R.string.service_connections_disconnect, new Object[0], null, 4), FormatUtils.h(context, R.string.cancel, new Object[0], null, 4), MapsJVM.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass2(notice))), null, 32, null);
    }

    private final DialogData requestRatingModalBuilder(Context context, StoreNotices.Dialog notice) {
        return new DialogData(FormatUtils.h(context, R.string.rating_request_title, new Object[0], null, 4), FormatUtils.h(context, R.string.rating_request_body_android, new Object[0], null, 4), FormatUtils.h(context, R.string.okay, new Object[0], null, 4), FormatUtils.h(context, R.string.no_thanks, new Object[0], null, 4), Maps6.mapOf(Tuples.to(0, AnonymousClass1.INSTANCE), Tuples.to(Integer.valueOf(R.id.notice_ok), AnonymousClass2.INSTANCE), Tuples.to(Integer.valueOf(R.id.notice_cancel), AnonymousClass3.INSTANCE)), Integer.valueOf(R.layout.view_review_request_modal_image));
    }

    public final void showNotice(Context context, FragmentManager fragmentManager, StoreNotices.Dialog notice) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(notice, "notice");
        Function2<Context, StoreNotices.Dialog, DialogData> function2 = noticeDataBuilders.get(notice.getType());
        DialogData dialogDataInvoke = function2 != null ? function2.invoke(context, notice) : null;
        if (dialogDataInvoke != null) {
            WidgetNoticeDialog.Companion.show$default(WidgetNoticeDialog.INSTANCE, fragmentManager, dialogDataInvoke.getHeaderText(), dialogDataInvoke.getBodyText(), dialogDataInvoke.getOkText(), dialogDataInvoke.getCancelText(), dialogDataInvoke.getListenerMap(), notice.getType(), dialogDataInvoke.getExtraLayoutId(), null, null, null, null, 0, null, 16128, null);
        }
    }
}
