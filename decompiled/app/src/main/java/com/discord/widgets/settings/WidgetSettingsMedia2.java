package com.discord.widgets.settings;

import android.view.View;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetSettingsMediaBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.CheckedSetting;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsMedia.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/view/View;", "p1", "Lcom/discord/databinding/WidgetSettingsMediaBinding;", "invoke", "(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsMediaBinding;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* renamed from: com.discord.widgets.settings.WidgetSettingsMedia$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsMedia2 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsMediaBinding> {
    public static final WidgetSettingsMedia2 INSTANCE = new WidgetSettingsMedia2();

    public WidgetSettingsMedia2() {
        super(1, WidgetSettingsMediaBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsMediaBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsMediaBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsMediaBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.attachments_toggle;
        CheckedSetting checkedSetting = (CheckedSetting) view.findViewById(R.id.attachments_toggle);
        if (checkedSetting != null) {
            i = R.id.compression_toggle;
            CheckedSetting checkedSetting2 = (CheckedSetting) view.findViewById(R.id.compression_toggle);
            if (checkedSetting2 != null) {
                i = R.id.compression_toggle_subtext;
                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R.id.compression_toggle_subtext);
                if (linkifiedTextView != null) {
                    i = R.id.settings_text_images_compression_header;
                    TextView textView = (TextView) view.findViewById(R.id.settings_text_images_compression_header);
                    if (textView != null) {
                        i = R.id.settings_text_images_display_header;
                        TextView textView2 = (TextView) view.findViewById(R.id.settings_text_images_display_header);
                        if (textView2 != null) {
                            i = R.id.settings_text_images_embeds_toggle;
                            CheckedSetting checkedSetting3 = (CheckedSetting) view.findViewById(R.id.settings_text_images_embeds_toggle);
                            if (checkedSetting3 != null) {
                                i = R.id.settings_text_images_links_toggle;
                                CheckedSetting checkedSetting4 = (CheckedSetting) view.findViewById(R.id.settings_text_images_links_toggle);
                                if (checkedSetting4 != null) {
                                    i = R.id.settings_text_images_preview_header;
                                    TextView textView3 = (TextView) view.findViewById(R.id.settings_text_images_preview_header);
                                    if (textView3 != null) {
                                        i = R.id.settings_text_images_stickers_header;
                                        TextView textView4 = (TextView) view.findViewById(R.id.settings_text_images_stickers_header);
                                        if (textView4 != null) {
                                            i = R.id.settings_text_images_sync_header;
                                            TextView textView5 = (TextView) view.findViewById(R.id.settings_text_images_sync_header);
                                            if (textView5 != null) {
                                                i = R.id.settings_text_images_sync_toggle;
                                                CheckedSetting checkedSetting5 = (CheckedSetting) view.findViewById(R.id.settings_text_images_sync_toggle);
                                                if (checkedSetting5 != null) {
                                                    i = R.id.stickers_suggestions;
                                                    CheckedSetting checkedSetting6 = (CheckedSetting) view.findViewById(R.id.stickers_suggestions);
                                                    if (checkedSetting6 != null) {
                                                        return new WidgetSettingsMediaBinding((CoordinatorLayout) view, checkedSetting, checkedSetting2, linkifiedTextView, textView, textView2, checkedSetting3, checkedSetting4, textView3, textView4, textView5, checkedSetting5, checkedSetting6);
                                                    }
                                                }
                                            }
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
