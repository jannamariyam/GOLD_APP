# Generated by Django 3.0.3 on 2022-02-14 16:23

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='GoldStatus',
            fields=[
                ('g_id', models.AutoField(primary_key=True, serialize=False)),
                ('image', models.CharField(max_length=150)),
            ],
            options={
                'db_table': 'gold_status',
                'managed': False,
            },
        ),
    ]
