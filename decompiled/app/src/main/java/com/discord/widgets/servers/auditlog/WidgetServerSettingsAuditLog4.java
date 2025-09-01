package com.discord.widgets.servers.auditlog;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsAuditLogBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetServerSettingsAuditLog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetServerSettingsAuditLogBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsAuditLogBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerSettingsAuditLog4 extends FunctionReferenceImpl implements Function1<View, WidgetServerSettingsAuditLogBinding> {
    public static final WidgetServerSettingsAuditLog4 INSTANCE = new WidgetServerSettingsAuditLog4();

    public WidgetServerSettingsAuditLog4() {
        super(1, WidgetServerSettingsAuditLogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerSettingsAuditLogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerSettingsAuditLogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsAuditLogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.no_logs_body;
        TextView textView = (TextView) view.findViewById(R.id.no_logs_body);
        if (textView != null) {
            i = R.id.no_logs_title;
            TextView textView2 = (TextView) view.findViewById(R.id.no_logs_title);
            if (textView2 != null) {
                i = R.id.server_settings_audit_logs_action_filter;
                TextView textView3 = (TextView) view.findViewById(R.id.server_settings_audit_logs_action_filter);
                if (textView3 != null) {
                    i = R.id.server_settings_audit_logs_action_filter_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.server_settings_audit_logs_action_filter_container);
                    if (linearLayout != null) {
                        i = R.id.server_settings_audit_logs_recycler;
                        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.server_settings_audit_logs_recycler);
                        if (recyclerView != null) {
                            i = R.id.server_settings_audit_logs_user_filter;
                            TextView textView4 = (TextView) view.findViewById(R.id.server_settings_audit_logs_user_filter);
                            if (textView4 != null) {
                                i = R.id.server_settings_audit_logs_user_filter_container;
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.server_settings_audit_logs_user_filter_container);
                                if (linearLayout2 != null) {
                                    i = R.id.server_settings_audit_logs_view_flipper;
                                    AppViewFlipper appViewFlipper = (AppViewFlipper) view.findViewById(R.id.server_settings_audit_logs_view_flipper);
                                    if (appViewFlipper != null) {
                                        i = R.id.server_settings_audit_logs_view_results_flipper;
                                        AppViewFlipper appViewFlipper2 = (AppViewFlipper) view.findViewById(R.id.server_settings_audit_logs_view_results_flipper);
                                        if (appViewFlipper2 != null) {
                                            return new WidgetServerSettingsAuditLogBinding((CoordinatorLayout) view, textView, textView2, textView3, linearLayout, recyclerView, textView4, linearLayout2, appViewFlipper, appViewFlipper2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
