# Generated by Django 3.0.3 on 2022-02-14 16:23

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Login',
            fields=[
                ('uid', models.AutoField(primary_key=True, serialize=False)),
                ('uname', models.CharField(max_length=50)),
                ('pwd', models.CharField(max_length=50)),
                ('utype', models.CharField(max_length=12)),
            ],
            options={
                'db_table': 'login',
                'managed': False,
            },
        ),
    ]
