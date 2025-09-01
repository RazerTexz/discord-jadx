package com.discord.widgets.hubs;

import androidx.core.app.NotificationCompat;
import b.a.d.AppViewModel;
import com.discord.api.hubs.WaitlistSignup;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.utilities.RestCallState;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.rest.RestAPI;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetHubWaitlistViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/discord/widgets/hubs/WidgetHubWaitlistViewModel;", "Lb/a/d/d0;", "Lcom/discord/widgets/hubs/HubWaitlistState;", "", "school", "", "joinWaitlist", "(Ljava/lang/String;)V", NotificationCompat.CATEGORY_EMAIL, "Ljava/lang/String;", "getEmail", "()Ljava/lang/String;", "Lcom/discord/utilities/rest/RestAPI;", "restAPI", "Lcom/discord/utilities/rest/RestAPI;", "getRestAPI", "()Lcom/discord/utilities/rest/RestAPI;", "<init>", "(Ljava/lang/String;Lcom/discord/utilities/rest/RestAPI;)V", "app_productionGoogleRelease"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class WidgetHubWaitlistViewModel extends AppViewModel<WidgetHubWaitlistViewModel3> {
    private final String email;
    private final RestAPI restAPI;

    /* compiled from: WidgetHubWaitlistViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/discord/stores/utilities/RestCallState;", "Lcom/discord/api/hubs/WaitlistSignup;", "async", "", "invoke", "(Lcom/discord/stores/utilities/RestCallState;)V", "<anonymous>"}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.discord.widgets.hubs.WidgetHubWaitlistViewModel$joinWaitlist$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState<? extends WaitlistSignup>, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends WaitlistSignup> restCallState) {
            invoke2((RestCallState<WaitlistSignup>) restCallState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState<WaitlistSignup> restCallState) {
            Intrinsics3.checkNotNullParameter(restCallState, "async");
            WidgetHubWaitlistViewModel3 widgetHubWaitlistViewModel3Access$getViewState$p = WidgetHubWaitlistViewModel.access$getViewState$p(WidgetHubWaitlistViewModel.this);
            if (widgetHubWaitlistViewModel3Access$getViewState$p != null) {
                WidgetHubWaitlistViewModel.access$updateViewState(WidgetHubWaitlistViewModel.this, widgetHubWaitlistViewModel3Access$getViewState$p.copy(restCallState));
            }
        }
    }

    public /* synthetic */ WidgetHubWaitlistViewModel(String str, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ WidgetHubWaitlistViewModel3 access$getViewState$p(WidgetHubWaitlistViewModel widgetHubWaitlistViewModel) {
        return widgetHubWaitlistViewModel.getViewState();
    }

    public static final /* synthetic */ void access$updateViewState(WidgetHubWaitlistViewModel widgetHubWaitlistViewModel, WidgetHubWaitlistViewModel3 widgetHubWaitlistViewModel3) {
        widgetHubWaitlistViewModel.updateViewState(widgetHubWaitlistViewModel3);
    }

    public final String getEmail() {
        return this.email;
    }

    public final RestAPI getRestAPI() {
        return this.restAPI;
    }

    public final void joinWaitlist(String school) {
        Intrinsics3.checkNotNullParameter(school, "school");
        RestCallState5.executeRequest(this.restAPI.joinHubWaitlist(new RestAPIParams.HubWaitlist(this.email, school)), new AnonymousClass1());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubWaitlistViewModel(String str, RestAPI restAPI) {
        super(new WidgetHubWaitlistViewModel3(null, 1, null));
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.email = str;
        this.restAPI = restAPI;
    }
}
